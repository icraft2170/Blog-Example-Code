package inner_class;

public class Client {

  public static void main(String[] args) {
    Product productA = Product.builder()
        .title("상품 A")
        .thumbnailImage("image.jpg")
        .price(1_000_000L)
        .description("상품 A는 좋습니다")
        .build();

    Product productB = Product.builder()
        .title("상품 B")
        .thumbnailImage("imageB.jpg")
        .description("상품 B는 좋습니다")
        .build();


    System.out.println(productA);
    System.out.println(productB);
  }
}
