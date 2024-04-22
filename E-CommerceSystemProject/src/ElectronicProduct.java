public class ElectronicProduct extends Product{

    // 2 Additional Attributes
    private String brand;
    private int warrantyPeriod;

    // Constructor
    public ElectronicProduct(int productId, String name, float price,
    String brand, int warrantyPeriod) {
        super(productId, name, price);
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    // Setters and Getters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

}
