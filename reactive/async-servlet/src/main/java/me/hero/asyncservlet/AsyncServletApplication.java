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
//  @RestController
//  public static class MyController {
//    RestTemplate restTemplate = new RestTemplate();
//    @GetMapping("/rest")
//    public String rest(@RequestParam int idx) {
//      String res = restTemplate.getForObject("http://localhost:8081/service?req={req}",
//          String.class, "rest" + idx);
//      return res;
//    }
//  }

//  @RestController
//  public static class MyController {
//    AsyncRestTemplate restTemplate = new AsyncRestTemplate();
//    @GetMapping("/rest")
//    public ListenableFuture<ResponseEntity<String>> rest(@RequestParam int idx) {
//      return restTemplate.getForEntity("http://localhost:8081/service?req={req}",
//          String.class, "rest" + idx);
//    }
//  }

  // Call Back Hellllllllllllllllllllllllllllllllllllllllll
  // 받아서 가공한다.
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
          .andAccept(s2 -> deferredResult.setResult(s2.getBody()));

//      ListenableFuture<ResponseEntity<String>> f1 = restTemplate.getForEntity(URL1, String.class, "rest" + idx);
//      f1.addCallback(s -> {
//        ListenableFuture<ResponseEntity<String>> f2 = restTemplate.getForEntity(URL2, String.class, s.getBody());
//              f2.addCallback(s2 -> {
//                ListenableFuture<String> f3 = myService.work(s2.getBody());
//                    f3.addCallback(
//                        result -> deferredResult.setResult(result),
//                        result1 -> deferredResult.setErrorResult(result1)
//                    );
//              }, e -> {
//                deferredResult.setErrorResult(e.getMessage());
//              });
//      }, e -> {
//        deferredResult.setErrorResult(e.getMessage());
//      });

      return deferredResult;
    }
  }

  public static class Completion {
    Completion next;
    Consumer<ResponseEntity<String>> con;
    Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> fn;
    public Completion() {
    }

    public Completion(Consumer<ResponseEntity<String>> con) {
      this.con = con;
    }

    public Completion(
        Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> fn) {
      this.fn = fn;
    }

    public static Completion from(ListenableFuture<ResponseEntity<String>> lf) {
      Completion completion = new Completion();
      lf.addCallback(
          completion::complete,
          completion::error
      );
      return completion;
    }


    public void andAccept(Consumer<ResponseEntity<String>> consumer) {
      Completion newCompletion = new Completion(consumer);
      this.next = newCompletion;
    }



    public Completion andApply(
        Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> fn) {
      Completion newCompletion = new Completion(fn);
      this.next = newCompletion;
      return newCompletion;
    }


    void complete(ResponseEntity<String> s) {
      if (next != null) next.run(s);
    }

    void run(ResponseEntity<String> value) {
      if(con != null) con.accept(value);
      else if (fn != null) {
        ListenableFuture<ResponseEntity<String>> lf = fn.apply(value);
        lf.addCallback(this::complete, this::error);
      }
    }

    void error(Throwable e) {

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
