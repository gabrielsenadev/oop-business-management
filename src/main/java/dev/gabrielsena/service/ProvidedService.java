package dev.gabrielsena.service;

import dev.gabrielsena.product.Product;

import java.util.ArrayList;

public class ProvidedService {

    private ProvidedServiceType type;
    private ArrayList<Product> products;
    private int cost;

    private int clientId;

    public ProvidedService(int clientId, ProvidedServiceType type, ArrayList<Product> products, int cost) {
        this.clientId = clientId;
        this.type = type;
        this.products = products;
        this.cost = cost;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ProvidedServiceType getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public int getClientId() {
        return clientId;
    }
}
