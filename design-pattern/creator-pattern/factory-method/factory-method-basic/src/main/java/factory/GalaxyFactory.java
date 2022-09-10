package factory;

import product.GalaxyPhone;
import product.Phone;

public class GalaxyFactory implements PhoneFactory{
  @Override
  public Phone createPhone() {
    return new GalaxyPhone();
  }
}
