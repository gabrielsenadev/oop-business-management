package dev.gabrielsena.service;

import dev.gabrielsena.product.Product;

import java.util.ArrayList;

public class ProvidedService {

    private ProvidedServiceType type;
    private ArrayList<Product> products;
    private float cost;

    private int clientId;

    public ProvidedService(int clientId, ProvidedServiceType type, ArrayList<Product> products, float cost) {
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

    public float getCost() {
        return cost;
    }

    public int getClientId() {
        return clientId;
    }
}
