package basic;

public class FirstAdapter implements Target{
  private final FirstAdaptee adaptee=  new FirstAdaptee();

  @Override
  public String task() {
    return adaptee.callStr();
  }
}
