package dev.gabrielsena;

import dev.gabrielsena.manager.ClientManager;
import dev.gabrielsena.manager.ServiceScheduler;
import dev.gabrielsena.manager.StockManager;
import dev.gabrielsena.prompt.GeneralPrompt;

import java.util.ArrayList;

public class BusinessManagement {

    private ClientManager clientManager;
    private ServiceScheduler serviceSchedulerManager;
    private StockManager stockManager;

    private static BusinessManagement instance = null;

    public static BusinessManagement getInstance() {
        if (instance == null) {
            instance = new BusinessManagement();
        }
        return instance;
    }

    public void setup() {
        System.out.println("Boas vindas ao seu gerenciador de negócio!");
        this.stockManager = new StockManager(new ArrayList<>());
        this.clientManager = new ClientManager(new ArrayList<>());
        this.serviceSchedulerManager = new ServiceScheduler(new ArrayList<>());
        System.out.println("Tudo certo! Sua loja está cadastrada; Agora qualquer pessoa pode fazer agendamentos, registrar produtos e muito mais.");
        new GeneralPrompt();
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public ServiceScheduler getServiceSchedulerManager() {
        return serviceSchedulerManager;
    }

    public StockManager getStockManager() {
        return stockManager;
    }
}
