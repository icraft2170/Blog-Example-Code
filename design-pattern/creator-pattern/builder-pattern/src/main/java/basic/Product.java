package basic;

public class Product {
    private String title;
    private Long price;
    private String description;
    private String thumbnailImage;

    public Product() {
    }

    public Product(String title, Long price, String description, String thumbnailImage) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.thumbnailImage = thumbnailImage;
    }

    @Override
    public String toString() {
        return "basic.Product{" +
            "title='" + title + '\'' +
            ", price=" + price +
            ", description='" + description + '\'' +
            ", thumbnailImage='" + thumbnailImage + '\'' +
            '}';
    }
}
