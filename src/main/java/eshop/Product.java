package eshop;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    Product(int id, String name, double price, int quantity) {
        if (id < 0) {
            throw new IllegalArgumentException("Product ID must not be negative value");
        }
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Product name must not be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Product price must not be negative value");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Product quantity must not be negative value");
        }
        this.id = id;
        this.name = name.trim();
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.quantity += quantity;
    }
}
