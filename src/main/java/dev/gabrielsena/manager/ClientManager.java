package dev.gabrielsena.manager;

import dev.gabrielsena.client.Client;

import java.util.ArrayList;

public class ClientManager {

    private ArrayList<Client> clients;
    public ClientManager(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

}
