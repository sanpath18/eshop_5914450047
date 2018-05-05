package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    private double defaultProductPrice = 50;
    private int defaultOrderItemQuantity = 10;
    private Product product;
    private OrderItem orderItem;

    @BeforeEach
    void setup() {
        product = new Product(1, "flash drive", defaultProductPrice, 20);
        orderItem = new OrderItem(product, defaultOrderItemQuantity);
    }

    @Test
    void testCreateZeroQuantityOrderItem() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, 0));
        assertEquals("Order item quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testCreateNegativeQuantityOrderItem() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, -10));
        assertEquals("Order item quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testCreateSlightlyNegativeQuantityOrderItem() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, -1));
        assertEquals("Order item quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testGetSubtotal() {
        assertEquals(defaultProductPrice * defaultOrderItemQuantity, orderItem.getSubtotal());
    }
}