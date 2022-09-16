package reactive;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

public class ReactiveEx {

  public static void main(String[] args) {
    Disposable subscribe = Flux.<Integer>create(e -> {
      //Subscription's request
      e.next(1);
      e.next(2);
      e.next(3);
      e.complete();
    }).subscribe(System.out::println);
//    subscribe.dispose();
//
//    Flux.<Integer>create(e -> {
//      //Subscription's request
//          e.next(1);
//          e.next(2);
//          e.next(3);
//          e.complete();
//        })
//        .log()
//        .map(s -> s * 10)
//        .log()
//        .subscribe(System.out::println); // onNext
  }

}
