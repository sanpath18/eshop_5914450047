package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setup() {
        order = new Order(1, LocalDateTime.now());
    }

    @Test
    void testCreateNegativeIdOrder() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Order(-1, LocalDateTime.now()));
        assertEquals("Order ID must not be negative value", exception.getMessage());
    }

    @Test
    void testGetTotalFromZeroOrderItem() {
        assertEquals(0, order.getTotal());
    }

    @Test
    void testGetTotalFromOneOrderItem() {
        Product product = new Product(1, "flash drive", 199, 20);
        order.addItem(product, 10);
        assertEquals(product.getPrice() * 10, order.getTotal());
    }

    @Test
    void testGetTotalFromTwoOrderItem() {
        Product product1 = new Product(1, "flash drive", 199, 20);
        Product product2 = new Product(3, "CD-RW", 100, 20);
        order.addItem(product1, 10);
        order.addItem(product2, 5);
        assertEquals((product1.getPrice() * 10) + (product2.getPrice() * 5), order.getTotal());
    }
}