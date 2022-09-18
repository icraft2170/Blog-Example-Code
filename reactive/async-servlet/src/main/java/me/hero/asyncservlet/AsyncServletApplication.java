package me.hero.asyncservlet;

import io.netty.channel.nio.NioEventLoopGroup;
import java.util.function.Consumer;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

@SpringBootApplication
@EnableAsync
public class AsyncServletApplication {

  @RestController
  public static class MyController {
    public static final String URL1 = "http://localhost:8081/service?req={req}";
    public static final String URL2 = "http://localhost:8081/service2?req={req}";
    @Autowired
    MyService myService;

    AsyncRestTemplate restTemplate = new AsyncRestTemplate(
        new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));
    @GetMapping("/rest")
    public DeferredResult<String> rest(@RequestParam int idx) {
      DeferredResult<String> deferredResult = new DeferredResult<>();

      Completion.from(restTemplate.getForEntity(URL1, String.class, "rest" + idx))
          .andApply(s1 -> restTemplate.getForEntity(URL2, String.class, s1.getBody()))
          .andApply(s3 -> myService.work(s3.getBody()))
          .andError(result -> deferredResult.setErrorResult(result.toString()))
          .andAccept(deferredResult::setResult);

      return deferredResult;
    }
  }

  public static class AcceptCompletion<S> extends Completion<S,Void> {
    Consumer<S> con;

    public AcceptCompletion(Consumer<S> con) {
      this.con = con;
    }

    @Override
    void run(S value) {
      con.accept(value);
    }
  }

  public static class ApplyCompletion<S,T> extends Completion<S,T> {
    Function<S, ListenableFuture<T >> fn;
    public ApplyCompletion(
        Function<S, ListenableFuture<T>> fn) {
      this.fn = fn;
    }

    @Override
    void run(S value) {
      ListenableFuture<T> lf = fn.apply(value);
      lf.addCallback(this::complete, this::error);
    }
  }

  public static class ErrorCompletion<T> extends Completion<T, T> {
    Consumer<Throwable> econ;

    public ErrorCompletion(Consumer<Throwable> econ) {
      this.econ = econ;
    }

    @Override
    void run(T value) {
      if (next != null) next.run(value);
    }

    @Override
    void error(Throwable e) {
      econ.accept(e);
    }
  }


  public static class Completion<S,T> {
    Completion next;
    public Completion() {
    }

    public static <S,T> Completion<S,T> from(ListenableFuture<T> lf) {
      Completion<S,T> completion = new Completion<>();
      lf.addCallback(
          completion::complete,
          completion::error
      );
      return completion;
    }

    public <V> Completion<T,V> andApply(
        Function<T, ListenableFuture<V>> fn) {
      Completion<T,V> newCompletion = new ApplyCompletion<>(fn);
      this.next = newCompletion;
      return newCompletion;
    }

    public Completion<T,T> andError(Consumer<Throwable> consumer) {
      Completion<T, T> newCompletion = new ErrorCompletion<>(consumer);
      this.next = newCompletion;
      return newCompletion;
    }

    public void andAccept(Consumer<T> consumer) {
      Completion<T, Void> newCompletion = new AcceptCompletion<>(consumer);
      this.next = newCompletion;
    }


    void complete(T s) {
      if (next != null) next.run(s);
    }
    void run(S value) {}
    void error(Throwable e) {
      if(next != null) next.error(e);
    }

  }

  
  

  @Service
  public static class MyService {
    @Async
    public ListenableFuture<String> work(String req) {
      return new AsyncResult<>(req + "/asyncwork");
    }

  }

  @Bean
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor te = new ThreadPoolTaskExecutor();
    te.setCorePoolSize(1);
    te.setMaxPoolSize(10);
    te.initialize();
    return te;
  }


  public static void main(String[] args) {
    SpringApplication.run(AsyncServletApplication.class, args);
  }
}
