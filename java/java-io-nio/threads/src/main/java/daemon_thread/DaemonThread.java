package daemon_thread;

public class DaemonThread {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(5000);
        System.out.println(Thread.currentThread() + " -> MyThread 종료");
      } catch (Exception e){}
    });
    //Daemon Thread 설정
    thread.setDaemon(true);
    thread.start();
    System.out.println(Thread.currentThread() + " ->  main() 종료");
  }
}
