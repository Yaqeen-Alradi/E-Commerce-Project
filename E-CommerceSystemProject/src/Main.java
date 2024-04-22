import javax.swing.SwingUtilities;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       //------------------GUI------------------------
        SwingUtilities.invokeLater(() -> {
            ECommerceGUI gui = new ECommerceGUI();
            gui.setVisible(true);
        });
        //-------------------GUI-----------------------
        // Create copy electronic product
        ElectronicProduct e1 = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 1);

        // Create copy clothing product
        ClothingProduct c1 = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");

        // Create copy book product
        BookProduct b1 = new BookProduct(3, "OOP", 39.99f, "O'Reilly", "X Publications");

        // Initialize variables
        int orderId = 1; // Initialize order ID counter
        Scanner S = new Scanner(System.in);

        // Get customer details from the user
        System.out.println("Welcome to the E-Commerce System!");
        System.out.print("Please enter your ID: ");
        int customerId = S.nextInt();
        S.nextLine(); // Consume newline
        System.out.print("Please enter your name: ");
        String name = S.nextLine();
        System.out.print("Please enter your address: ");
        String address = S.nextLine();

        // Create customer
        Customer C = new Customer(customerId, name, address);

        // Create shopping cart for the customer
        System.out.print("How many products do you want to add to your cart? ");
        int nProducts = S.nextInt();
        Cart R = new Cart(customerId, nProducts);

        // Add products to the cart
        for (int i = 0; i < nProducts; i++) {
            System.out.println("Which product would you like to add?\n*Press 1 for SmartPhone, 2 for T-Shirt, 3 for OOP");
            int choice = S.nextInt();
            switch (choice) {
                case 1:
                    R.addProduct(e1);
                    break;
                case 2:
                    R.addProduct(c1);
                    break;
                case 3:
                    R.addProduct(b1);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        // Print total price and ask if the user wants to place the order
        float totalPrice = R.calculatePrice();
        System.out.printf("Your total is $%.2f. Would you like to place the order?\n*Press 1 for Yes, 2 for No\n", totalPrice);
        int orderChoice = S.nextInt();
        if (orderChoice == 1) {
            // Place the order
            Order order = new Order(customerId, orderId++, R.getProductsArray());
            System.out.println("Order placed successfully!:D");
            System.out.println();
            System.out.println("Here's your order's summary:");
            order.printOrderInfo();
        } else {
            System.out.println("Order Cancelled.");
        }
    }
}
