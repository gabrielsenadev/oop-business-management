package dev.gabrielsena.prompt.client;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.prompt.PromptOptionExecutor;
import dev.gabrielsena.service.ScheduledService;
import dev.gabrielsena.client.Client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScheduleServicePromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        System.out.println("Digite o identificador do cliente:");
        Scanner scanner = new Scanner(System.in);
        try {
            int clientIdInput = Integer.parseInt(scanner.nextLine());
            Client client = BusinessManagement.getInstance().getClientManager().getClients().stream().filter(c -> c.getId() == clientIdInput).findFirst().orElseThrow();
            ArrayList<Date> available = BusinessManagement.getInstance().getServiceSchedulerManager().getAvailableScheduledServiceDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            System.out.println("Horários disponíveis:");
            available.stream().map(d -> "[" + (available.indexOf(d) + 1) + "] " + dateFormat.format(d)).forEach(System.out::println);
            int selected = Integer.parseInt(scanner.nextLine());
            Date selectedDate = available.get(selected - 1);
            ScheduledService service = new ScheduledService(selectedDate, client.getId());
            BusinessManagement.getInstance().getServiceSchedulerManager().addScheduledService(service);
            System.out.println("Serviço para o(a) cliente agendado!");
            System.out.println("Cliente: "+ client.getName());
            System.out.println("Horário: "+ dateFormat.format(selectedDate));
            return true;
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                System.out.println("Cliente ou serviço não encontrado");
            }
            return false;
        }
    }

    @Override
    public String getTitle() {
        return "Agendar serviço para o cliente";
    }
}
