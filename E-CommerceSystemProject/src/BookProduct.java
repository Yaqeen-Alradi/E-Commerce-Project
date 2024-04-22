public class BookProduct extends Product {
    // 2 Additional Attributes
    private String author;
    private String publisher;

    // Constructor
    public BookProduct(int productId, String name, float price,
    String author, String publisher) {
        super(productId, name, price);
        this.author = author;
        this.publisher = publisher;

    }

    // Setters and Getters
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

}
