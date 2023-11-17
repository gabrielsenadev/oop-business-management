package dev.gabrielsena.product;

public class Product {

    private String name;
    private int id;
    private int quantity;

    public Product(int id, String name, int quantity) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeOne() {
        if (this.quantity - 1 < 0) {
            throw new ProductQuantityChangeError();
        }
        this.quantity -= 1;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
