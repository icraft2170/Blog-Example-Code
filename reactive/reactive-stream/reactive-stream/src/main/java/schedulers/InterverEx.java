package schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class InterverEx {

  public static void main(String[] args) {
    Publisher<Integer> pub = sub -> {
      sub.onSubscribe(new Subscription() {
        int no = 0;
        boolean canceled = false;
        @Override
        public void request(long n) {
          ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
          exec.scheduleAtFixedRate(() -> {
            if (canceled) {
              exec.shutdown();
              return;
            }
            sub.onNext(no++);
          }, 0, 300, TimeUnit.MICROSECONDS);
        }

        @Override
        public void cancel() {
          canceled = true;
        }
      });
    };

    Publisher<Integer> takePub = sub -> {
      pub.subscribe(new Subscriber<Integer>() {
        int count = 0;
        Subscription subscription;

        @Override
        public void onSubscribe(Subscription s) {
          subscription = s;
          sub.onSubscribe(s);
        }

        @Override
        public void onNext(Integer integer) {
          if (++count >= 10) {
            subscription.cancel();
          }
          sub.onNext(integer);
        }

        @Override
        public void onError(Throwable t) {
          sub.onError(t);
        }

        @Override
        public void onComplete() {
          sub.onComplete();
        }
      });
    };

    takePub.subscribe(new Subscriber<Integer>() {
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
  }

}
