package schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

/**
 * SubOn -> 생성이 느리고 처리가 빠른 경우 ( Publisher 를 다른 스레드로 나누는 방법 )
 * PubOn -> 생성이 빠르고 처리가 느린 경우 ( Subscriber 를 다른 스레드로 나누는 방법 )
 */
@Slf4j
public class SchedulersEx {
  // Reactive Streams
  public static void main(String[] args) {
    Publisher<Integer> pub = (subscriber) -> {
      subscriber.onSubscribe(new Subscription() {
        @Override
        public void request(long n) {
          log.debug("request()");
          subscriber.onNext(1);
          subscriber.onNext(2);
          subscriber.onNext(3);
          subscriber.onNext(4);
          subscriber.onNext(5);
          subscriber.onComplete();
        }
        @Override
        public void cancel() {
        }
      });
    };

    Publisher<Integer> subOnPub = sub -> {
      ExecutorService es = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("subOn-"));
      es.execute(() -> pub.subscribe(sub));
    };

//    Publisher<Integer> pubOnPub = sub -> {
//      subOnPub.subscribe(new Subscriber<Integer>() {
//        ExecutorService es = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("pubOn-"));
//        @Override
//        public void onSubscribe(Subscription s) {
//          sub.onSubscribe(s);
//        }
//
//        @Override
//        public void onNext(Integer integer) {
//          es.execute(() -> sub.onNext(integer));
//        }
//
//        @Override
//        public void onError(Throwable t) {
//          es.execute(() -> sub.onError(t));
//        }
//
//        @Override
//        public void onComplete() {
//          es.execute(() -> sub.onComplete());
//        }
//      });
//    };

    Publisher<Integer> pubOnPub = sub -> {
      subOnPub.subscribe(new Subscriber<Integer>() {
        ExecutorService es = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("pubOn-"));
        @Override
        public void onSubscribe(Subscription s) {
          sub.onSubscribe(s);
        }

        @Override
        public void onNext(Integer integer) {
          es.execute(() -> sub.onNext(integer));
        }

        @Override
        public void onError(Throwable t) {
          es.execute(() -> sub.onError(t));
          es.shutdown();
        }

        @Override
        public void onComplete() {
          es.execute(() -> sub.onComplete());
          es.shutdown();
        }
      });
    };


    pubOnPub.subscribe(new Subscriber<Integer>() {
      @Override
      public void onSubscribe(Subscription s) {
        log.debug("onSubscribe");
        s.request(Long.MAX_VALUE);
      }

      @Override
      public void onNext(Integer integer) {
        log.debug("onNext: {}", integer);
      }

      @Override
      public void onError(Throwable t) {
        log.error("onError: {}", t);
      }

      @Override
      public void onComplete() {
        log.debug("onComplete");
      }
    });
    log.info("main exit");
  }
}
