public class Order {
    // 4 Attributes
    private int customerId;
    private int orderId;
    private Product[] Products;
    private float totalPrice;
    // Constructor
    public Order(int customerId, int orderId, Product[] Products) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.Products = Products;
        calculateTotalPrice();
    }
    // Product array
    public Product[] getProducts() {
        return Products;
    }
    // Setters and Getters
    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }
    public void setOrderId(int orderId) {
        this.orderId = Math.abs(orderId);
    }
    public void setProducts(Product[] products) {
        this.Products = products;
        calculateTotalPrice();
    }
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = Math.abs(totalPrice);
    }
    public int getCustomerId() {
        return customerId;
    }
    public int getOrderId() {
        return orderId;
    }
    public float getTotalPrice() {
        return totalPrice;
    }

    // Method Calculate the total price of all products in the order
    private void calculateTotalPrice() {
        totalPrice = 0;
        if (Products != null) {
            for (Product product : Products) {
                if (product != null) {
                    totalPrice += product.getPrice();
                }
            }
        }
    }
    // Method to print order information
    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        if (Products != null) {
            for (Product product : Products) {
                if (product != null) {
                    System.out.println("- " + product.getName() + " (Price: $" + product.getPrice() + ")");
                }
            }
        }
        System.out.println("Total Price: $" + totalPrice);
        System.out.println();
        System.out.println("thank you for your time!^-^");
    }
}
