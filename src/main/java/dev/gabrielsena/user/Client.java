package dev.gabrielsena.user;

import dev.gabrielsena.service.ProvidedService;

import java.util.ArrayList;

public class Client extends User {
    private ArrayList<ProvidedService> servicesHistory;
    private String phoneNumber;

    public Client(int id, String name, String phoneNumber, ArrayList<ProvidedService> servicesHistory) {
        super(id, name);
        this.servicesHistory = servicesHistory;
        this.phoneNumber = phoneNumber;
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

}
