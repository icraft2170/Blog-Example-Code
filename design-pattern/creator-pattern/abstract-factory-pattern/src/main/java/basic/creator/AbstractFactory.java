package basic.creator;

import basic.product.ProductA;
import basic.product.ProductB;

public interface AbstractFactory {
  ProductA createProductA();

  ProductB createProductB();
}
