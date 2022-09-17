package basic;

public class Client {
  public static void main(String[] args) {
    Builder builderA = new ConcreteBuilder();
    Product productA = builderA.title("상품 A")
        .thumbnailImage("image.jpg")
        .price(1_000_000L)
        .description("상품 A는 좋습니다")
        .build();

    Builder builderB = new ConcreteBuilder();
    Product productB = builderB.title("상품 B")
        .thumbnailImage("imageB.jpg")
        .description("상품 B는 좋습니다")
        .build();

    System.out.println(productA);
    System.out.println(productB);
  }
}
