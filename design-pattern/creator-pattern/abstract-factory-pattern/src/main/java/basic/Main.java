package basic;

import basic.creator.Client;
import basic.creator.ConcreteFactory;

public class Main {

  public static void main(String[] args) {
    Client client = new Client(new ConcreteFactory());
    System.out.println(client);
  }
}
