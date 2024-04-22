public class Customer {
    // 3 Attributes
    private int customerId;
    private String name;
    private String address;

    // Constructor
    public Customer(int customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    // Setters and Getters
    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

}
