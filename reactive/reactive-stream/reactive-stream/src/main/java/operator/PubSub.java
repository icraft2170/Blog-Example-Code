package operator;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 * Reactive Stream : Operator
 *
 * Publisher -> [Data1] -> Operator1 -> [Data2] -> Operator2 -> [Data3] -> Subscriber
 *
 * ----------------------------------------------------------------------------------------
 * pub -> [Data1] -> mapPub -> [Data2] -> Operator2 -> [Data3] -> Subscriber
 * ----------------------------------------------------------------------------------------
 *                          <- subscribe(logSub)
 *                          -> onSubScribe(s)
 *                          -> onNext()
 *                          -> onNext() ...
 *                          -> onComplete
 *
 * Operator : 데이터 이동 과정에서 가공, 일종의 Stream Method 메커니
 * Map :
 */
@Slf4j
public class PubSub {

  public static void main(String[] args) {
    Publisher<Integer> pub = iterPub(Stream.iterate(1, i -> i + 1).limit(10).collect(toList()));
    Publisher<Integer> mapPub = mapPub(pub, (Function<Integer, Integer>) (s -> s * 10));
    Publisher<Integer> map2Pub = mapPub(mapPub, (Function<Integer, Integer>) (s -> s * 10));
    Subscriber<Integer> sub = logsub();
    map2Pub.subscribe(sub);
  }

  private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> fuc) {
    return new Publisher<Integer>() {
      @Override
      public void subscribe(Subscriber<? super Integer> subscriber) {
        pub.subscribe(new Subscriber<Integer>() {
          @Override
          public void onSubscribe(Subscription subscription) {
            subscriber.onSubscribe(subscription);
          }

          @Override
          public void onNext(Integer item) {
            subscriber.onNext(fuc.apply(item));
          }

          @Override
          public void onError(Throwable throwable) {
            subscriber.onError(throwable);
          }

          @Override
          public void onComplete() {
            subscriber.onComplete();
          }
        });
      }
    };
  }

  private static Subscriber<Integer> logsub() {
    return new Subscriber<Integer>() {
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
