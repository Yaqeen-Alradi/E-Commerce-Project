import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ECommerceGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String[] selectedProducts = new String[3]; // Array to store selected products
    private int customerId;

    public ECommerceGUI() {
        setTitle("E-Commerce System Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        Container contentPane = getContentPane();
        ImageIcon image = new ImageIcon("logo.png");
        setIconImage(image.getImage());
        setVisible(true);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        cardPanel.add(createWelcomePanel(), "Welcome");
        cardPanel.add(createCustomerDetailsPanel(), "CustomerDetails");
        cardPanel.add(createProductSelectionPanel(), "ProductSelection");
        cardPanel.add(createOrderConfirmationPanel(), "OrderConfirmation");
        cardPanel.add(createOrderSummaryPanel(), "OrderSummary");

        add(cardPanel);

        setVisible(true);
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("hello.png");
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.CENTER);

        JLabel helloLabel = new JLabel("Hello!");
        helloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(helloLabel, BorderLayout.NORTH);

        JLabel welcomeLabel = new JLabel("Welcome to the E-Commerce System!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.SOUTH);

        JButton nextButton = new JButton("Press the button to start");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "CustomerDetails");
            }
        });
        panel.add(nextButton, BorderLayout.PAGE_END);

        return panel;
    }

    private JPanel createCustomerDetailsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 1));

        JLabel idLabel = new JLabel("Please enter your ID:");
        JTextField idField = new JTextField(10);
        inputPanel.add(idLabel);
        inputPanel.add(idField);

        JLabel nameLabel = new JLabel("Please enter your name:");
        JTextField nameField = new JTextField(20);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        JLabel addressLabel = new JLabel("Please enter your address:");
        JTextField addressField = new JTextField(30);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerId = Integer.parseInt(idField.getText());
                cardLayout.show(cardPanel, "ProductSelection");
            }
        });
        buttonPanel.add(nextButton);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }


    private JPanel createProductSelectionPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel productPanel = new JPanel(new GridLayout(3, 1));

        JCheckBox smartphoneCheckbox = new JCheckBox("Smartphone - $599.9");
        JCheckBox tshirtCheckbox = new JCheckBox("T-shirt - $19.99");
        JCheckBox bookCheckbox = new JCheckBox("OOP Book - $39.99");

        productPanel.add(smartphoneCheckbox);
        productPanel.add(tshirtCheckbox);
        productPanel.add(bookCheckbox);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the previous selections
                selectedProducts[0] = smartphoneCheckbox.isSelected() ? "Smartphone - $599.9" : null;
                selectedProducts[1] = tshirtCheckbox.isSelected() ? "T-shirt - $19.99" : null;
                selectedProducts[2] = bookCheckbox.isSelected() ? "OOP Book - $39.99" : null;
                float totalPrice = calculateTotalPrice(selectedProducts);
                updateOrderConfirmation(totalPrice);
                cardLayout.show(cardPanel, "OrderConfirmation");
            }
        });
        buttonPanel.add(nextButton);

        panel.add(productPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createOrderConfirmationPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel confirmationLabel = new JLabel("Your total is $0.0. Would you like to place the order?");
        confirmationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(confirmationLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton yesButton = new JButton("Yes");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "OrderSummary");
                updateOrderSummary();
            }
        });
        buttonPanel.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(noButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createOrderSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea summaryTextArea = new JTextArea();
        summaryTextArea.setEditable(false);
        summaryTextArea.append("Order placed successfully!:D\n");
        summaryTextArea.append("Here's your order's summary:\n");
        summaryTextArea.append("Customer ID: " + customerId + "\n");
        summaryTextArea.append("Selected Products:\n");
        for (String product : selectedProducts) {
            if (product != null) {
                summaryTextArea.append("- " + product + "\n");
            }
        }
        summaryTextArea.append("Total Price: $" + calculateTotalPrice(selectedProducts) + "\n");
        summaryTextArea.append("thank you for your time!^-^");

        JScrollPane scrollPane = new JScrollPane(summaryTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(closeButton, BorderLayout.SOUTH);

        return panel;
    }

    private float calculateTotalPrice(String[] selectedProducts) {
        float totalPrice = 0.0f;
        for (String product : selectedProducts) {
            if (product != null) {
                if (product.contains("Smartphone")) {
                    totalPrice += 599.9f;
                } else if (product.contains("T-shirt")) {
                    totalPrice += 19.99f;
                } else if (product.contains("OOP Book")) {
                    totalPrice += 39.99f;
                }
            }
        }
        return totalPrice;
    }

    private void updateOrderConfirmation(float totalPrice) {
        JPanel orderConfirmationPanel = (JPanel) cardPanel.getComponent(3);
        JLabel confirmationLabel = (JLabel) orderConfirmationPanel.getComponent(0);
        confirmationLabel.setText("Your total is $" + totalPrice + ". Would you like to place the order?");
    }

    private void updateOrderSummary() {
        JPanel orderSummaryPanel = (JPanel) cardPanel.getComponent(4);
        JTextArea summaryTextArea = (JTextArea) ((JScrollPane) orderSummaryPanel.getComponent(0)).getViewport().getView();
        summaryTextArea.setText("Here's your order's summary:\n");
        summaryTextArea.append("Customer ID: " + customerId + "\n");
        summaryTextArea.append("Selected Products:\n");
        for (String product : selectedProducts) {
            if (product != null) {
                summaryTextArea.append("- " + product + "\n");
            }
        }
        summaryTextArea.append("Total Price: $" + calculateTotalPrice(selectedProducts) + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ECommerceGUI();
            }
        });
    }
}
