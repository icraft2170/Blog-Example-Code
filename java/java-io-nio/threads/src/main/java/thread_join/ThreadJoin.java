package thread_join;

public class ThreadJoin {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread() + " -> MyThread 종료");
        Thread.sleep(3000);
      } catch (Exception e){}
    });

    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("main() 종료");
  }
}
