package bean_factory.product;

public class ConcreteMailSender implements MailSender{
  private final String name = "MAIL-SENDER";

  @Override
  public String getName() {
    return name;
  }
}
