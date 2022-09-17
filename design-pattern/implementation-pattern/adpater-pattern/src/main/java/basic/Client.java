package basic;

public class Client {
  static Target target;

  public static void main(String[] args) {
    target = new FirstAdapter();
    System.out.println(target.task());

    target = new SecondAdapter();
    System.out.println(target.task());
  }
}
