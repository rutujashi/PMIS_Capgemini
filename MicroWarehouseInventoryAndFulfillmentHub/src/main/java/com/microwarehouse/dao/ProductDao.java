package com.microwarehouse.dao;
import com.microwarehouse.model.Product;
import com.microwarehouse.model.TopProduct;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductDao {

	    private final JdbcTemplate jdbcTemplate;

	    public ProductDao(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    // Display all products
	    public List<Product> getAllProducts() {

	        String sql = "SELECT * FROM products";

	        return jdbcTemplate.query(sql, (rs, rowNum) ->
	            new Product(
	                rs.getInt("sku_id"),
	                rs.getString("name"),
	                rs.getString("category"),
	                rs.getBigDecimal("unit_price"),
	                rs.getInt("stock_qty")
	            )
	        );
	    }

	    // Get product by SKU
	    public Product getProductById(int skuId) {

	        String sql =
	            "SELECT * FROM products WHERE sku_id = ?";

	        List<Product> products = jdbcTemplate.query(
	            sql,
	            (rs, rowNum) -> new Product(
	                rs.getInt("sku_id"),
	                rs.getString("name"),
	                rs.getString("category"),
	                rs.getBigDecimal("unit_price"),
	                rs.getInt("stock_qty")
	            ),
	            skuId
	        );

	        return products.isEmpty() ? null : products.get(0);
	    }

	    // FR1: Add new product
	    public int addProduct(Product product) {

	        String sql = """
	            INSERT INTO products
	            (name, category, unit_price, stock_qty)
	            VALUES (?, ?, ?, ?)
	            """;

	        return jdbcTemplate.update(
	            sql,
	            product.getName(),
	            product.getCategory(),
	            product.getUnitPrice(),
	            product.getStockQty()
	        );
	    }

	    // FR1: Replenish stock
	    public int replenishStock(int skuId, int quantity) {

	        String sql = """
	            UPDATE products
	            SET stock_qty = stock_qty + ?
	            WHERE sku_id = ?
	            """;

	        return jdbcTemplate.update(sql, quantity, skuId);
	    }

	    // FR3: Atomic stock deduction
	    public int deductStock(int skuId, int quantity) {

	        String sql = """
	            UPDATE products
	            SET stock_qty = stock_qty - ?
	            WHERE sku_id = ?
	            AND stock_qty >= ?
	            """;

	        return jdbcTemplate.update(
	            sql, quantity, skuId, quantity
	        );
	    }

	    // FR4: Low stock alerts
	    public List<Product> getLowStockProducts() {

	        String sql = """
	            SELECT * FROM products
	            WHERE stock_qty < 10
	            """;

	        return jdbcTemplate.query(sql, (rs, rowNum) ->
	            new Product(
	                rs.getInt("sku_id"),
	                rs.getString("name"),
	                rs.getString("category"),
	                rs.getBigDecimal("unit_price"),
	                rs.getInt("stock_qty")
	            )
	        );
	    }

	    // FR5: Top selling products
	    public List<TopProduct> getTopSellingProducts() {

	        String sql = """
	            SELECT p.name, SUM(oi.quantity) AS total_quantity
	            FROM order_items oi
	            JOIN products p ON oi.sku_id = p.sku_id
	            JOIN orders o ON oi.order_id = o.order_id
	            WHERE o.order_status = 'CONFIRMED'
	            GROUP BY p.sku_id, p.name
	            ORDER BY total_quantity DESC
	            """;

	        return jdbcTemplate.query(sql, (rs, rowNum) ->
	            new TopProduct(
	                rs.getString("name"),
	                rs.getInt("total_quantity")
	            )
	        );
	    }

	    // FR5: Total sales revenue
	    public BigDecimal getTotalRevenue() {

	        String sql = """
	            SELECT COALESCE(SUM(oi.subtotal), 0)
	            FROM order_items oi
	            JOIN orders o ON oi.order_id = o.order_id
	            WHERE o.order_status = 'CONFIRMED'
	            """;

	        return jdbcTemplate.queryForObject(
	            sql, BigDecimal.class
	        );
	    }
}
