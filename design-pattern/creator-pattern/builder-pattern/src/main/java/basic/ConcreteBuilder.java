package basic;

public class ConcreteBuilder implements Builder{
  private String title;
  private Long price;
  private String description;
  private String thumbnailImage;

  @Override
  public Builder title(String title) {
    this.title = title;
    return this;
  }

  @Override
  public Builder price(Long price) {
    this.price = price;
    return this;
  }

  @Override
  public Builder description(String description) {
    this.description = description;
    return this;
  }

  @Override
  public Builder thumbnailImage(String thumbnailImage) {
    this.thumbnailImage = thumbnailImage;
    return this;
  }

  @Override
  public Product build() {
    return new Product(title, price, description, thumbnailImage);
  }
}
