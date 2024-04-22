public class Cart {
    // 3 Attributes
    private int customerId;
    private int nProducts;
    private Product[] products;
   // Constructor
    public Cart(int customerId, int nProducts) {
        this.customerId = customerId;
        this.products = new Product[nProducts];
    }
    // Setters and Getters
    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }
    public void setNProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
        this.products = new Product[nProducts];
    }
    public int getCustomerId() {
        return customerId;
    }
    public int getNProducts() {
        return nProducts;
    }
    public Product[] getProducts() {
        return products;
    }
    // Method Add a product to the cart
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
    }
    // Method Remove a product from the cart
    public void removeProduct(int index) {
        if (index >= 0 && index < nProducts) {
            for (int i = index; i < nProducts - 1; i++) {
                products[i] = products[i + 1];
            }
            products[nProducts - 1] = null;
            nProducts--;
        }
    }
    // Method Calculate the total price of all products in the cart
    public float calculatePrice() {
        float totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                totalPrice += products[i].getPrice();
            }
        }
        return totalPrice;
    }

    public Product[] getProductsArray() {
        return products;
    }


}
