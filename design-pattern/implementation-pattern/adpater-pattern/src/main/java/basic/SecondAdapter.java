package basic;

import org.apache.coyote.Adapter;

public class SecondAdapter implements Target {

  private final SecondAdaptee adaptee = new SecondAdaptee();

  @Override
  public String task() {
    return adaptee.requestName();
  }
}
