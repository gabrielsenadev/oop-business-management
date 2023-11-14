package dev.gabrielsena.manager;

import dev.gabrielsena.product.Product;

import java.util.ArrayList;

public class StockManager {

    private ArrayList<Product> products;

    public StockManager(ArrayList<Product> products) {
        this.products = products;
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Product getProduct(String productName) {
        return this.products.stream().filter(product -> product.getName().equalsIgnoreCase(productName)).findFirst().orElseThrow();
    }

    public Product getProduct(int productId) {
        return this.products.stream().filter(product -> product.getId() == productId).findFirst().orElseThrow();
    }
}
