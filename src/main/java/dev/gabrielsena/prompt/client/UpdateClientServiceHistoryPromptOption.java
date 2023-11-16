package dev.gabrielsena.prompt.client;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.product.Product;
import dev.gabrielsena.prompt.PromptOptionExecutor;
import dev.gabrielsena.prompt.client.servicehistory.SelectProvidedServiceType;
import dev.gabrielsena.prompt.client.servicehistory.SetCostProvidedService;
import dev.gabrielsena.prompt.client.servicehistory.SetProductsProvidedService;
import dev.gabrielsena.service.ProvidedService;
import dev.gabrielsena.service.ProvidedServiceType;
import dev.gabrielsena.user.Client;

import java.util.*;

public class UpdateClientServiceHistoryPromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        System.out.println("Digite o identificador do cliente:");
        Scanner scanner = new Scanner(System.in);
        try {
            int clientIdInput = Integer.parseInt(scanner.nextLine());
            Client client = BusinessManagement.getInstance().getClientManager().getClients().stream().filter(c -> c.getId() == clientIdInput).findFirst().orElseThrow();
            System.out.println("Encontramos o(a) cliente " + client.getName() + " de número de telefone: " + client.getPhoneNumber() + ".");
            System.out.println("Siga as instruções para registrar o serviço realizado ao cliente.");
            System.out.println("Caso queira cancelar, digite a letra C.");
            String serviceType = (String) new SelectProvidedServiceType(scanner).start();
            if (Objects.isNull(serviceType)) {
                System.out.println("Cancelado.");
                return true;
            }
            Object serviceCost = new SetCostProvidedService(scanner).start();
            if (Objects.isNull(serviceCost)) {
                System.out.println("Cancelado.");
                return true;
            }
            Object serviceProductsStart = new SetProductsProvidedService(scanner).start();
            if (Objects.isNull(serviceProductsStart)) {
                System.out.println("Cancelado.");
                return true;
            }
            ArrayList<Product> products = (ArrayList<Product>) serviceProductsStart;
            int serviceTypeInt = Integer.parseInt(serviceType);
            ProvidedServiceType parsedServiceType = ProvidedServiceType.values()[serviceTypeInt - 1];
            ProvidedService providedService = new ProvidedService(client.getId(), parsedServiceType, products, (float) serviceCost);
            products.forEach(Product::removeOne);
            client.getServicesHistory().add(providedService);
            System.out.println("Pronto! Serviço adicionado no histórico do cliente.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            if (e instanceof NoSuchElementException) {
                System.out.println("Cliente não encontrado");
            }
            return false;
        }
    }
}
