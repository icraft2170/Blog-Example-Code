package basic;

public class Client {



  public static void main(String[] args) {
    Abstraction abstractionA = new Abstraction(new ConcreteImplementorA());
    abstractionA.Operation();

    Abstraction abstractionB = new Abstraction(new ConcreteImplementorB());
    abstractionB.Operation();
  }

}
