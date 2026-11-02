package com.microwarehouse.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create order
    public int createOrder(String phone) {

        String sql = """
            INSERT INTO orders
            (customer_phone, order_status)
            VALUES (?, 'CONFIRMED')
            """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                connection.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS
                );

            ps.setString(1, phone);
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();

        if (key == null) {
            throw new IllegalStateException(
                "Order ID was not generated"
            );
        }

        return key.intValue();
    }

    // FR2: Batch insert order items
    public void insertOrderItems(
        int orderId,
        List<Integer> skuIds,
        List<Integer> quantities,
        List<BigDecimal> subtotals
    ) {

        String sql = """
            INSERT INTO order_items
            (order_id, sku_id, quantity, subtotal)
            VALUES (?, ?, ?, ?)
            """;

        jdbcTemplate.batchUpdate(
            sql,
            new BatchPreparedStatementSetter() {

                @Override
                public void setValues(
                    PreparedStatement ps, int i
                ) throws SQLException {

                    ps.setInt(1, orderId);
                    ps.setInt(2, skuIds.get(i));
                    ps.setInt(3, quantities.get(i));
                    ps.setBigDecimal(4, subtotals.get(i));
                }

                @Override
                public int getBatchSize() {
                    return skuIds.size();
                }
            }
        );
    }
}
