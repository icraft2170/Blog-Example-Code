package basic.product;

public class ConcreteProductB implements ProductB {
  private final String name = "PRODUCT-B";

  @Override
  public String getName() {
    return name;
  }
}
