package factory;

import product.IPhone;
import product.Phone;

public class IPhoneFactory implements PhoneFactory {
  @Override
  public Phone createPhone() {
    return new IPhone();
  }
}
