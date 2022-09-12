package inner_class;

public class Product {
    private String title;
    private Long price;
    private String description;
    private String thumbnailImage;

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private String title;
        private Long price;
        private String description;
        private String thumbnailImage;

        public ProductBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder price(Long price) {
            this.price = price;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder thumbnailImage(String thumbnailImage) {
            this.thumbnailImage = thumbnailImage;
            return this;
        }

        public Product build() {
            return new Product(title, price, description, thumbnailImage);
        }
    }


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
