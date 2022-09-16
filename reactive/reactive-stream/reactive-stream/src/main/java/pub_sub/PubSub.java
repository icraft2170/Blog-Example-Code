package pub_sub;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 * Reactive Stream
 */
@Slf4j
public class PubSub {

  public static void main(String[] args) {
    Publisher<Integer> pub = iterPub(Stream.iterate(1, i -> i + 1).limit(10).collect(toList()));

    Subscriber<Integer> sub = new Subscriber<Integer>() {
      @Override
      public void onSubscribe(Subscription subscription) {
        log.debug("onSubscribe: ");
        subscription.request(Long.MAX_VALUE);
      }

      @Override
      public void onNext(Integer item) {
        log.debug("onNext: {}", item);
      }

      @Override
      public void onError(Throwable t) {
        log.error("onError: {}", t);
      }

      @Override
      public void onComplete() {
        log.debug("onComplete");
      }
    };

    // Cold observer
    pub.subscribe(sub);

  }

  private static Publisher<Integer> iterPub(List<Integer> iter) {
    return new Publisher<Integer>() {
      @Override
      public void subscribe(Subscriber<? super Integer> sub) {
        sub.onSubscribe(
            new Subscription() {
              @Override
              public void request(long n) {
                try {
                  iter.forEach(sub::onNext);
                  sub.onComplete();
                } catch (Throwable tr) {
                  sub.onError(tr);
                }
              }
              @Override
              public void cancel() {

              }
            });
      }
    };
  }

}
