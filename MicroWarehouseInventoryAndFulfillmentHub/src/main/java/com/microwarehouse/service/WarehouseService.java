package com.microwarehouse.service;

import com.microwarehouse.dao.ProductDao;
import com.microwarehouse.dao.OrderDao;
import com.microwarehouse.model.Product;
import com.microwarehouse.model.OrderItemRequest;
import com.microwarehouse.model.TopProduct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class WarehouseService {

    private final ProductDao productDao;
    private final OrderDao orderDao;

    public WarehouseService(
        ProductDao productDao,
        OrderDao orderDao
    ) {
        this.productDao = productDao;
        this.orderDao = orderDao;
    }

    // FR1: Register product
    public void addProduct(Product product) {

        if (product.getUnitPrice() == null ||
            product.getUnitPrice().compareTo(BigDecimal.ZERO) <= 0 ||
            product.getStockQty() < 0) {
            throw new IllegalArgumentException(
                "Invalid price or stock quantity"
            );
        }

        productDao.addProduct(product);

        System.out.println("Product added successfully!");
    }

    // FR1: Replenish stock
    public void replenishStock(int skuId, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                "Quantity must be greater than zero"
            );
        }

        int rows = productDao.replenishStock(
            skuId, quantity
        );

        if (rows == 0) {
            throw new RuntimeException("Product not found!");
        }

        System.out.println("Stock replenished successfully!");
    }

    // Display products
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    // FR3: Atomic multi-item order
    @Transactional
    public int placeOrder(
        String phone,
        List<OrderItemRequest> items
    ) {

        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException(
                "Customer phone is required"
            );
        }

        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException(
                "Order must contain at least one item"
            );
        }

        // Combine duplicate SKUs
        Map<Integer, Integer> requestedItems =
            new LinkedHashMap<>();

        for (OrderItemRequest item : items) {

            if (item.getSkuId() <= 0 ||
                item.getQuantity() <= 0) {
                throw new IllegalArgumentException(
                    "Invalid SKU or quantity"
                );
            }

            requestedItems.merge(
                item.getSkuId(),
                item.getQuantity(),
                Math::addExact
            );
        }

        List<Integer> skuIds = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<BigDecimal> subtotals = new ArrayList<>();

        // Verify all products and calculate subtotals
        for (Map.Entry<Integer, Integer> entry :
             requestedItems.entrySet()) {

            int skuId = entry.getKey();
            int quantity = entry.getValue();

            Product product =
                productDao.getProductById(skuId);

            if (product == null) {
                throw new RuntimeException(
                    "Product not found: " + skuId
                );
            }

            BigDecimal subtotal =
                product.getUnitPrice().multiply(
                    BigDecimal.valueOf(quantity)
                );

            skuIds.add(skuId);
            quantities.add(quantity);
            subtotals.add(subtotal);
        }

        // Create order
        int orderId = orderDao.createOrder(phone);

        // Deduct stock only if sufficient stock exists
        for (int i = 0; i < skuIds.size(); i++) {

            int updated = productDao.deductStock(
                skuIds.get(i),
                quantities.get(i)
            );

            if (updated == 0) {
                throw new RuntimeException(
                    "Insufficient stock for SKU: "
                    + skuIds.get(i)
                    + ". Entire order cancelled."
                );
            }
        }

        // FR2: Insert all items using batchUpdate()
        orderDao.insertOrderItems(
            orderId,
            skuIds,
            quantities,
            subtotals
        );

        return orderId;
    }

    // FR4: Low stock alerts
    public List<Product> getLowStockProducts() {
        return productDao.getLowStockProducts();
    }

    // FR5: Revenue
    public BigDecimal getTotalRevenue() {
        return productDao.getTotalRevenue();
    }

    // FR5: Top selling
    public List<TopProduct> getTopSellingProducts() {
        return productDao.getTopSellingProducts();
    }
}
