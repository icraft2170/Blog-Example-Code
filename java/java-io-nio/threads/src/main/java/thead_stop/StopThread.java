package thead_stop;

public class StopThread implements Runnable{
  @Override
  public void run() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println("Thread is alive..");
        Thread.sleep(500);
      }
    } catch (InterruptedException exception) {}
    finally {
      System.out.println("Thread is dead");
    }
  }
}
