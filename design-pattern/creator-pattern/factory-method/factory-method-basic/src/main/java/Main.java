import factory.GalaxyFactory;
import factory.IPhoneFactory;

public class Main {
  public static void main(String[] args) {
    // Dependency Injection
    Client client1 = new Client(new GalaxyFactory());
    // Dependency Injection
    Client client2 = new Client(new IPhoneFactory());

    client1.getClientPhone();
    client2.getClientPhone();
  }
}
