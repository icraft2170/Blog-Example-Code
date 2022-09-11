package basic.product;

public class ConcreteProductA implements ProductA {
  private final String name = "PRODUCT-A";

  @Override
  public String getName() {
    return name;
  }
}
