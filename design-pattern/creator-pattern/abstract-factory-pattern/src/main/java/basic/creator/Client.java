package basic.creator;

import basic.product.ProductA;
import basic.product.ProductB;
import java.util.concurrent.ConcurrentHashMap;

public class Client {
  private final AbstractFactory abstractFactory;
  private final ProductA productA;
  private final ProductB productB;

  public Client(AbstractFactory abstractFactory) {
    this.abstractFactory = abstractFactory;
    this.productA = abstractFactory.createProductA();
    this.productB = abstractFactory.createProductB();
  }

  @Override
  public String toString() {
    return "Client{" +
        "abstractFactory=" + abstractFactory +
        ", productA=" + productA.getName() +
        ", productB=" + productB.getName() +
        '}';
  }
}
