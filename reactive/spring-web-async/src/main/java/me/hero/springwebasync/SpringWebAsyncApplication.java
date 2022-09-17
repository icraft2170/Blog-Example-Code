package me.hero.springwebasync;

import java.awt.geom.CubicCurve2D;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
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
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Slf4j
@SpringBootApplication
@EnableAsync
public class SpringWebAsyncApplication {

  @RestController
  public static class MyController {
    Queue<DeferredResult<String>> results = new ConcurrentLinkedQueue<>();

    @GetMapping("/emiiter")
    public ResponseBodyEmitter async() {
      ResponseBodyEmitter emitter = new ResponseBodyEmitter();

      Executors.newSingleThreadExecutor().submit(() -> {
        for (int i = 0; i <= 50; i++) {
          try {
            emitter.send("<p> Stream" + i + "/<p>");
            Thread.sleep(100);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      });
      return emitter;
    }

  }


  //  @RestController
//  public static class MyController {
//    Queue<DeferredResult<String>> results = new ConcurrentLinkedQueue<>();
//
//    @GetMapping("/dr")
//    public DeferredResult<String> async() {
//      log.info("dr");
//      DeferredResult<String> result = new DeferredResult<>(6000000L);
//      results.add(result);
//      return result;
//    }
//
//    @GetMapping("/dr/count")
//    public String drCount() {
//      return String.valueOf(results.size());
//    }
//
//    @GetMapping("/dr/event")
//    public String drEvent(String message) {
//      for (DeferredResult<String> result : results) {
//        result.setResult("Hello " + message);
//        results.remove(result);
//      }
//      return "OK";
//    }
//  }



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

//  @RestController
//  public static class MyController {
//    @SneakyThrows
//    @GetMapping("/callable")
//    public String async() {
//      log.info("async");
//      Thread.sleep(2000);
//      return "Hello";
//    }
//  }



  public static void main(String[] args) {
    SpringApplication.run(SpringWebAsyncApplication.class, args);
  }

}
