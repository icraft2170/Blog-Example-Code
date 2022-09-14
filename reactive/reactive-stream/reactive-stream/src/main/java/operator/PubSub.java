package operator;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.BiFunction;
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
 * Operator : 데이터 이동 과정에서 가공, 일종의 Stream Method 메커니즘
 * Map :
 */
@Slf4j
public class PubSub {

  public static void main(String[] args) {
    Publisher<Integer> pub = iterPub(Stream.iterate(1, i -> i + 1).limit(10).collect(toList()));
//    Publisher<String> mapPub = mapPub(pub, s -> "[" + s + "]");
//    Publisher<Integer> sumPub = sumPub(pub);
    Publisher<String> reduce = reduce(pub, "", (a,b) -> a + " - " + b);
//    Subscriber<Integer> sub = logsub();
    reduce.subscribe(logsub());
  }

  private static <T, R> Publisher<R> reduce(Publisher<T> pub, R init, BiFunction<R, T, R> function) {
    return new Publisher<R>() {
      @Override
      public void subscribe(Subscriber<? super R> subscriber) {
        pub.subscribe(new Subscriber<T>() {
          R result = init;
          @Override
          public void onSubscribe(Subscription subscription) {
            subscriber.onSubscribe(subscription);
          }

          @Override
          public void onNext(T item) {
            result = function.apply(result, item);
          }

          @Override
          public void onError(Throwable throwable) {
            subscriber.onError(throwable);
          }

          @Override
          public void onComplete() {
            subscriber.onNext(result);
            subscriber.onComplete();
          }
        });
      }
    };
  }

  private static Publisher<Integer> sumPub(Publisher<Integer> pub) {
    return new Publisher<Integer>() {
      @Override
      public void subscribe(Subscriber<? super Integer> subscriber) {
        pub.subscribe(new Subscriber<Integer>() {
          int sum = 0;
          @Override
          public void onSubscribe(Subscription subscription) {
            subscriber.onSubscribe(subscription);
          }


          @Override
          public void onNext(Integer item) {
            sum += item;
          }

          @Override
          public void onError(Throwable throwable) {
            subscriber.onError(throwable);
          }
          @Override
          public void onComplete() {
              subscriber.onNext(sum);
              subscriber.onComplete();
          }
        });
      }
    };
  }


  private static <T, R> Publisher<R> mapPub(Publisher<T> pub, Function<T, R> fuc) {
    return new Publisher<R>() {
      @Override
      public void subscribe(Subscriber<? super R> subscriber) {
        pub.subscribe(new Subscriber<T>() {
          @Override
          public void onSubscribe(Subscription subscription) {
            subscriber.onSubscribe(subscription);
          }

          @Override
          public void onNext(T item) {
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
  private static <T> Subscriber<T> logsub() {
    return new Subscriber<T>() {
      @Override
      public void onSubscribe(Subscription subscription) {
        log.debug("onSubscribe: ");
        subscription.request(Long.MAX_VALUE);
      }

      @Override
      public void onNext(T item) {
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
