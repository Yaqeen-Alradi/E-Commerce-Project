public class ClothingProduct extends Product {

    // 2 Additional Attributes
    private String size;
    private String fabric;

    // Constructor
    public ClothingProduct(int productId, String name, float price,
    String size, String fabric) {
        super(productId, name, price);
        this.fabric = fabric;
        this.size = size;
    }

    // Setters and Getters
    public void setSize(String size) {
        this.size = size;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }
    public String getSize() {
        return size;
    }

    public String getFabric() {
        return fabric;
    }
}
