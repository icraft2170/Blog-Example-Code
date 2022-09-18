package me.hero.asyncservlet;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
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

  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    ExecutorService es = Executors.newFixedThreadPool(100);
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/rest?idx={idx}";

    CyclicBarrier barrier = new CyclicBarrier(101);
    StopWatch main = new StopWatch();

    main.start();
    for (int i = 0; i < 100; i++) {
      es.submit(() -> {
        int id = count.addAndGet(1);
        barrier.await();
        log.info("Thread - " + id);
        StopWatch sw = new StopWatch();
        sw.start();
        String res = restTemplate.getForObject(url, String.class, id);
        sw.stop();
        log.info("Elapsed : {} -> {} res : {}", id, sw.getTotalTimeSeconds(), res);
        return null;
      });
    }
    barrier.await();
    es.shutdown();
    es.awaitTermination(100, TimeUnit.SECONDS);
    main.stop();


    log.info("Total Time Seconds : {}", main.getTotalTimeSeconds());
  }

}
