package dev.gabrielsena.prompt.client;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.prompt.PromptOptionExecutor;

public class ListClientsPromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        if (BusinessManagement.getInstance().getClientManager().getClients().isEmpty()) {
            System.out.println("Não há clientes registrados.");
            return true;
        }
        System.out.println("ID    NOME    CELULAR");
        BusinessManagement.getInstance().getClientManager().getClients().stream().map(client -> client.getId() + "    "+ client.getName() + "   "+ client.getPhoneNumber()).forEach(System.out::println);
        return true;
    }

    @Override
    public String getTitle() {
        return "Listar clientes";
    }
}
