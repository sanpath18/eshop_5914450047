package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product something;

    @BeforeEach
    void setup() {
        something = new Product(1, "flash drive", 199, 20);
    }

    @Test
    void testCreateNegativeIdProduct() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(-1, "DVD-R", 100, 20));
        assertEquals("Product ID must not be negative value", exception.getMessage());
    }

    @Test
    void testCreateSpaceOnlyNameProduct() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "   ", 80, 20));
        assertEquals("Product name must not be empty", exception.getMessage());
    }

    @Test
    void testCreateEmptyNameProduct() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "", 80, 20));
        assertEquals("Product name must not be empty", exception.getMessage());
    }

    @Test
    void testCreateNegativePriceProduct() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "DVD-R", -80, 20));
        assertEquals("Product price must not be negative value", exception.getMessage());
    }

    @Test
    void testCreateNegativeQuantityProduct() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "DVD-R", 80, -20));
        assertEquals("Product quantity must not be negative value", exception.getMessage());
    }

    @Test
    void testAddQuantityNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> something.addQuantity(-10));
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testAddQuantitySlightlyNegative() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> something.addQuantity(-1));
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testAddQuantityZero() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> something.addQuantity(0));
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testAddQuantityPositive() {
        something.addQuantity(10);
        assertEquals(30, something.getQuantity());
    }

    @Test
    void testAddQuantitySlightlyPositive() {
        something.addQuantity(1);
        assertEquals(21, something.getQuantity());
    }

}