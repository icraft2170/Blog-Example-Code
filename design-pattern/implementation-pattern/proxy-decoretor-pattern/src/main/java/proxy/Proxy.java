package proxy;

public class Proxy implements Subject{
  private Subject subject;
  int count = 1;

  public Proxy(Subject subject) {
    this.subject = subject;
  }

  @Override
  public void request() {
    if (count > 5) {
      System.out.println("5회이상 요청 불가");
      return;
    }
    count++;
    subject.request();
  }
}
