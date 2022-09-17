package asynchronous.toby;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureEx {
  interface SuccessCallback {
    void onSuccess(String result);
  }

  interface ExceptionCallback {
    void onError(Throwable throwable);
  }
  public static class CallbackFutureTask extends FutureTask<String> {
    SuccessCallback successCallback;
    ExceptionCallback exceptionCallback;
    public CallbackFutureTask(Callable<String> callable, SuccessCallback successCallback, ExceptionCallback ec) {
      super(callable);
      this.successCallback = Objects.requireNonNull(successCallback);
      this.exceptionCallback = Objects.requireNonNull(ec);
    }

    @Override
    protected void done() {
      try {
        successCallback.onSuccess(get());
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } catch (ExecutionException e) {
        exceptionCallback.onError(e);
      }
    }
  }


  public static void main(String[] args) {
    // Thread Pool 생성
    ExecutorService es = Executors.newCachedThreadPool();

    CallbackFutureTask callbackFutureTask = new CallbackFutureTask(() -> {
      Thread.sleep(2000);
      if (true) {
        throw new RuntimeException("알 수 없는 예외 발생");
      }
      log.info("Async");
      return "Hello";
    }, System.out::println, e -> log.error("Error(에러): " + e.getMessage()));

    es.execute(callbackFutureTask);
    es.shutdown();
  }

}
