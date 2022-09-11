package basic.creator;

import basic.product.ConcreteProductA;
import basic.product.ConcreteProductB;
import basic.product.ProductA;
import basic.product.ProductB;

public class ConcreteFactory implements AbstractFactory {
  @Override
  public ProductA createProductA() {
    return new ConcreteProductA();
  }

  @Override
  public ProductB createProductB() {
    return new ConcreteProductB();
  }
}
