package schedulers;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxEx {

  public static void main(String[] args) {
    Flux.range(1, 10)
        .publishOn(Schedulers.newSingle("pubOn-"))
        .log()
        .subscribeOn(Schedulers.newSingle("subOn-"))
        .log()
        .subscribe(System.out::println);

    System.out.println("exit");
  }

}
