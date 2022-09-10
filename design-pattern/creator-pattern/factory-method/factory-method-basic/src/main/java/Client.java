import factory.GalaxyFactory;
import factory.IPhoneFactory;
import factory.PhoneFactory;
import product.Phone;

public class Client {
  private final PhoneFactory phoneFactory;

  public Client(PhoneFactory phoneFactory) {
    this.phoneFactory = phoneFactory;
  }

  public void getClientPhone() {
    Phone phone = phoneFactory.orderPhone();
    System.out.println(phone);
  }

}
