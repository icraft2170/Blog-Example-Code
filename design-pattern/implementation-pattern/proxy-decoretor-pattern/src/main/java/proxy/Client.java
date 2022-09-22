package proxy;

public class Client {

  static Subject subject;

  public static void main(String[] args) {
    subject = new Proxy(new RealSubject());
    subject.request();
    subject.request();
    subject.request();
    subject.request();
    subject.request();
    subject.request();
  }

}
