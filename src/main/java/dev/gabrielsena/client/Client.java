package dev.gabrielsena.client;

import dev.gabrielsena.service.ProvidedService;

import java.util.ArrayList;

public class Client {

    private int id;
    private String name;
    private ArrayList<ProvidedService> servicesHistory;
    private String phoneNumber;

    public Client(int id, String name, String phoneNumber, ArrayList<ProvidedService> servicesHistory) {
        this.servicesHistory = servicesHistory;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.name = name;
    }

    public ArrayList<ProvidedService> getServicesHistory() {
        return servicesHistory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
