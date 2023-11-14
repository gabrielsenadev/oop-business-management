package dev.gabrielsena.prompt.client;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.prompt.PromptOptionExecutor;
import dev.gabrielsena.service.ScheduledService;
import dev.gabrielsena.user.Client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class ViewClientPromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        System.out.println("Digite o identificador do cliente:");
        Scanner scanner = new Scanner(System.in);
        try {
            int clientIdInput = Integer.parseInt(scanner.nextLine());
            Client client = BusinessManagement.getInstance().getClientManager().getClients().stream().filter(c -> c.getId() == clientIdInput).findFirst().orElseThrow();
            System.out.println("Informações do cliente");
            System.out.println("Nome do Cliente: "+ client.getName());
            System.out.println("Identificador: "+ client.getId());
            System.out.println("Número de telefone: "+ client.getPhoneNumber());
            if (!client.getServicesHistory().isEmpty()) {
                System.out.println("Serviços realizados:");
                client.getServicesHistory().stream().map(c -> "TIPO: " + c.getType() + " CUSTO:" + c.getCost()).forEach(System.out::println);
            }
            this.printScheduledServicesByClientId(client.getId());
            return true;
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                System.out.println("Cliente não encontrado");
            }
            return false;
        }
    }

    private void printScheduledServicesByClientId(int clientId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        boolean hasServices = BusinessManagement.getInstance().getServiceSchedulerManager().getScheduledServices().stream().anyMatch(s -> s.getClientId() == clientId);
        if (!hasServices) {
            return;
        }
        Stream<ScheduledService> services = BusinessManagement.getInstance().getServiceSchedulerManager().getScheduledServices().stream().filter(s -> s.getClientId() == clientId);
        System.out.println("Serviços agendados para o cliente:");
        services.map(s -> dateFormat.format(s.getTime())).forEach(System.out::println);
    }
}
