package schedulers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class FluxScEx {
  public static void main(String[] args) throws InterruptedException {
    Flux.interval(Duration.ofMillis(200))
        .take(10)
//        .subscribeOn(Schedulers.newSingle("subOn"))
        .subscribe(s -> log.debug("onNext(): {}", s));

    log.debug("exit");
    TimeUnit.SECONDS.sleep(10);
  }

}
