package basic;

import java.util.Objects;

public class PrototypeProduct {
  private String title;
  private Long price;
  public PrototypeProduct(String title, Long price) {
    this.title = title;
    this.price = price;
  }

  public PrototypeProduct clone() {
    return new PrototypeProduct(title, price);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PrototypeProduct that)) {
      return false;
    }
    return Objects.equals(title, that.title) && Objects.equals(price, that.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, price);
  }

  @Override
  public String toString() {
    return "PrototypeProduct{" +
        "title='" + title + '\'' +
        ", price=" + price +
        '}';
  }

}
