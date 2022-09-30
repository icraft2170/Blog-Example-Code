package thead_stop;

public class StopThreadTest {
  public static void main(String[] args) {
    System.out.println("Start ThreadTest");
    StopThreadTest stopThreadTest = new StopThreadTest();
    stopThreadTest.process();
  }

  public void process() {
    StopThread run = new StopThread();
    Thread thread = new Thread(run);
    thread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 실행한 스레드에 InterruptException 을 발생시킨다.
    thread.interrupt();
  }
}
