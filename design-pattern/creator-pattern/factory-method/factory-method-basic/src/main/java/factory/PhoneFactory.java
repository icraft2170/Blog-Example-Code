package factory;

import product.Phone;

public interface PhoneFactory {
  default Phone orderPhone(){
    Phone phone = createPhone();
    System.out.println(phone.getName() + "를 주문합니다. ");
    return phone;
  }
  Phone createPhone();
}
