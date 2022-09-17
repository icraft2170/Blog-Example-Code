package basic;

public class Abstraction {
  private final Implementor implementor;

  public Abstraction(Implementor implementor) {
    this.implementor = implementor;
  }

  public void Operation() {
    implementor.operationImp();
  }
}
