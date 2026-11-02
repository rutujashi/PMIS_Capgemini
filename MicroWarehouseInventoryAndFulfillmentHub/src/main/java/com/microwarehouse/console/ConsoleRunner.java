package com.microwarehouse.console;


import com.microwarehouse.model.Product;
import com.microwarehouse.model.OrderItemRequest;
import com.microwarehouse.service.WarehouseService;
import com.microwarehouse.model.TopProduct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final WarehouseService service;

    public ConsoleRunner(WarehouseService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n================================");
            System.out.println(" MICRO WAREHOUSE INVENTORY HUB");
            System.out.println("================================");

            System.out.println("1. Display All Products");
            System.out.println("2. Add New Product");
            System.out.println("3. Replenish Stock");
            System.out.println("4. Create Customer Order");
            System.out.println("5. Low Stock Alerts");
            System.out.println("6. Total Sales Revenue");
            System.out.println("7. Top Selling Products");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(
                    sc.nextLine().trim()
                );

                switch (choice) {

                    case 1:
                        displayProducts();
                        break;

                    case 2:
                        addProduct(sc);
                        break;

                    case 3:
                        replenishStock(sc);
                        break;

                    case 4:
                        createOrder(sc);
                        break;

                    case 5:
                        lowStockAlerts();
                        break;

                    case 6:
                        showRevenue();
                        break;

                    case 7:
                        showTopSelling();
                        break;

                    case 8:
                        System.out.println(
                            "Thank you! Application closed."
                        );
                        return;

                    default:
                        System.out.println(
                            "Invalid choice. Try again."
                        );
                }

            } catch (Exception e) {
                System.out.println(
                    "Error: " + e.getMessage()
                );
            }
        }
    }

    // 1. Display products
    private void displayProducts() {

        List<Product> products =
            service.getAllProducts();

        System.out.println("\n----- PRODUCT LIST -----");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }

    // 2. Add product
    private void addProduct(Scanner sc) {

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter unit price: ");
        BigDecimal price =
            new BigDecimal(sc.nextLine());

        System.out.print("Enter stock quantity: ");
        int stock =
            Integer.parseInt(sc.nextLine());

        Product product = new Product(
            0, name, category, price, stock
        );

        service.addProduct(product);
    }

    // 3. Replenish stock
    private void replenishStock(Scanner sc) {

        System.out.print("Enter SKU ID: ");
        int skuId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        service.replenishStock(skuId, quantity);
    }

    // 4. Create order
    private void createOrder(Scanner sc) {

        System.out.print("Enter customer phone: ");
        String phone = sc.nextLine();

        List<OrderItemRequest> items =
            new ArrayList<>();

        while (true) {

            System.out.print("Enter SKU ID: ");
            int skuId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter quantity: ");
            int quantity =
                Integer.parseInt(sc.nextLine());

            items.add(
                new OrderItemRequest(skuId, quantity)
            );

            System.out.print(
                "Add another item? (yes/no): "
            );

            String answer = sc.nextLine();

            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }

        int orderId = service.placeOrder(phone, items);

        System.out.println(
            "Order confirmed successfully!"
        );

        System.out.println("Order ID: " + orderId);
    }

    // 5. Low stock
    private void lowStockAlerts() {

        List<Product> products =
            service.getLowStockProducts();

        System.out.println("\n----- LOW STOCK ALERTS -----");

        if (products.isEmpty()) {
            System.out.println(
                "No low stock products."
            );
            return;
        }

        for (Product p : products) {
            System.out.println(
                "ALERT: " + p.getName() +
                " | Remaining stock: " + p.getStockQty()
            );
        }
    }

    // 6. Revenue
    private void showRevenue() {

        BigDecimal revenue =
            service.getTotalRevenue();

        System.out.println(
            "Total Sales Revenue: Rs. " + revenue
        );
    }

    // 7. Top selling
    private void showTopSelling() {

        List<TopProduct> products =
            service.getTopSellingProducts();

        System.out.println(
            "\n----- TOP SELLING PRODUCTS -----"
        );

        if (products.isEmpty()) {
            System.out.println("No sales available.");
            return;
        }

        for (TopProduct p : products) {
            System.out.println(p);
        }
    }
}