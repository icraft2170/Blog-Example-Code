package basic;

public interface Builder {
  Builder title(String title);

  Builder price(Long price);

  Builder description(String description);

  Builder thumbnailImage(String thumbnailImage);

  Product build();
}
