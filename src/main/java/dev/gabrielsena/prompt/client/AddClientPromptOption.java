package dev.gabrielsena.prompt.client;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.prompt.PromptOptionExecutor;
import dev.gabrielsena.user.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class AddClientPromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        System.out.println("Digite o nome do cliente:");
        Scanner scanner = new Scanner(System.in);
        String nameInput = scanner.nextLine();
        System.out.println("Agora digite o número de telefone:");
        String phoneNumberInput = scanner.nextLine();
        int clientId = BusinessManagement.getInstance().getClientManager().getClients().size() + 1;
        Client client = new Client(clientId, nameInput, phoneNumberInput, new ArrayList<>());
        BusinessManagement.getInstance().getClientManager().addClient(client);
        String successClientCreatedMessage = "Cliente " + client.getName() + " de identificador " + client.getId() + " do número de telefone " + client.getPhoneNumber() + " criado com sucesso!";
        System.out.println(successClientCreatedMessage);
        return true;
    }
}
