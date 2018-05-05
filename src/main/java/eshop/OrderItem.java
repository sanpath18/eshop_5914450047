package eshop;

public class OrderItem {
    private Product product;
    private int quantity;

    OrderItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Order item quantity must be greater than zero");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
