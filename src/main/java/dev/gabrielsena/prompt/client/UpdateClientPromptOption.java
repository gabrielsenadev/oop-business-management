package dev.gabrielsena.prompt.client;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.prompt.PromptOptionExecutor;
import dev.gabrielsena.service.ScheduledService;
import dev.gabrielsena.user.Client;

import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class UpdateClientPromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        System.out.println("Digite o identificador do cliente:");
        Scanner scanner = new Scanner(System.in);
        try {
            int clientIdInput = Integer.parseInt(scanner.nextLine());
            Client client = BusinessManagement.getInstance().getClientManager().getClients().stream().filter(c -> c.getId() == clientIdInput).findFirst().orElseThrow();
            System.out.println("Encontramos o(a) cliente " + client.getName() + " de número de telefone: " + client.getPhoneNumber() + ".");
            System.out.println("Digite as novas informações ou digite C para cancelar.");
            String nameInput = ClientPromptOptionsCommons.requestClientName(scanner);
            if (this.isCancelCommand(nameInput)) {
                return true;
            }
            String phoneNumberInput = ClientPromptOptionsCommons.requestClientPhoneNumber(scanner);
            if (this.isCancelCommand(nameInput)) {
                return true;
            }
            client.setName(nameInput);
            client.setPhoneNumber(phoneNumberInput);
            System.out.println("Informações do cliente atualizadas com sucesso!");
            return true;
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                System.out.println("Cliente não encontrado");
            }
            return false;
        }
    }

    private boolean isCancelCommand(String input) {
        return input.equalsIgnoreCase("C");
    }
}
