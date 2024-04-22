public class Product {

    // 3 Attributes
    private int productId;
    private String name;
    private float price;

    // Constructor
    public Product(int productId, String name, float price) {
        this.productId = productId;
        this.name = name;
        this.price = Math.abs(price);
    }

    // Setters and Getters
    public void setProductId(int productId) {
        this.productId = Math.abs(productId);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = Math.abs(price);
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}



