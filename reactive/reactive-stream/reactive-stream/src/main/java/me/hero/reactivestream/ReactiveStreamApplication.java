package me.hero.reactivestream;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableAsync
public class ReactiveStreamApplication {

//  @RestController
//  public static class MyController {
//    @GetMapping("/callable")
//    public Callable<String> async() {
//      log.info("callable()");
//      return () -> {
//        log.info("async");
//        Thread.sleep(2000);
//        return "Hello";
//      };
//    }
//  }

  @RestController
  public static class MyController {
    @SneakyThrows
    @GetMapping("/callable")
    public String async() {
      log.info("async");
      Thread.sleep(2000);
      return "Hello";
    }
  }


//  @Component
//  public static class MyService {
//    @Async
//    public ListenableFuture<String> hello() throws InterruptedException {
//      log.debug("hello()");
//      Thread.sleep(10000);
//      return new AsyncResult<>("hello");
//    }
//  }
//
//  @Bean
//  public ThreadPoolTaskExecutor taskExecutor() {
//    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//    threadPoolTaskExecutor.setCorePoolSize(10);
//    threadPoolTaskExecutor.setQueueCapacity(50);
//    threadPoolTaskExecutor.setMaxPoolSize(100);
//    threadPoolTaskExecutor.setKeepAliveSeconds(1000);
//    threadPoolTaskExecutor.setThreadNamePrefix("myThread-");
//    threadPoolTaskExecutor.initialize();
//    return threadPoolTaskExecutor;
//  }

  public static void main(String[] args) {
//    try (ConfigurableApplicationContext c = SpringApplication.run(ReactiveStreamApplication.class,
//        args)) {
//    }
    SpringApplication.run(ReactiveStreamApplication.class, args);
  }

//  @Autowired
//  MyService myService;
//  @Bean
//  ApplicationRunner run () {
//    return args -> {
//      log.info("run()");
//      ListenableFuture<String> f = myService.hello();
//      f.addCallback(s -> System.out.println(s), e -> System.out.println(e.getMessage()));
//      System.out.println(f.isDone());
////      log.info("exit() : {}", hello.isDone());
//      log.info("result() : {}", f.get());
//    };
//  }

}
