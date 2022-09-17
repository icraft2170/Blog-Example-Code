package me.hero.springwebasync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class LoadTest {
  static AtomicInteger count = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    ExecutorService es = Executors.newFixedThreadPool(100);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/dr";
    StopWatch main = new StopWatch();

    main.start();
    for (int i = 0; i < 100; i++) {
      es.execute(() -> {
        int id = count.addAndGet(1);
        log.info("Thread - " + id);
        StopWatch sw = new StopWatch();
        sw.start();
        restTemplate.getForObject(url, String.class);
        sw.stop();
        log.info("Elapsed : {} -> {}",id , sw.getTotalTimeSeconds());
      });
    }
    es.shutdown();
    es.awaitTermination(100, TimeUnit.SECONDS);
    main.stop();


    log.info("Total Time Seconds : {}", main.getTotalTimeSeconds());
  }

}
