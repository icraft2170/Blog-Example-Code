package me.hero.cfutre;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CFuture {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
//    CompletableFuture<Integer> future = CompletableFuture.completedFuture(1);
//    future.complete(1);
//    System.out.println(future.get());
    CompletableFuture
        .supplyAsync(() -> {
          log.info("runAsync");
          return 1;
        })
        .thenApply((i) -> {
          log.info("thenRun");
          return i + 1;
        })
        .thenAccept((i2) -> log.info("i2 = {}", i2));

    log.info("exit");

  }
}
