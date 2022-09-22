package proxy;

public class RealSubject implements Subject{
  @Override
  public void request() {
    System.out.println("요청이 성공 하였습니다.");
  }
}
