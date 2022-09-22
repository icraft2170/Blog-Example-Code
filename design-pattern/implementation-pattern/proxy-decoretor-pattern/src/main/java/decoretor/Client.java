package decoretor;

public class Client {

  static Component component;

  public static void main(String[] args) {
    component = new Decorator(new ConcreteComponent());
    String response = component.operator();
    System.out.println(response);
  }

}
