package product;

public class Phone {
  private String name;
  private String os;
  private Long price;

  public Phone() {
  }

  public Phone(String name, String os, Long price) {
    this.name = name;
    this.os = os;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getOs() {
    return os;
  }

  public Long getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "\uD83D\uDCDE{" +
        "name='" + name + '\'' +
        ", os='" + os + '\'' +
        ", price=" + price +
        '}';
  }
}
