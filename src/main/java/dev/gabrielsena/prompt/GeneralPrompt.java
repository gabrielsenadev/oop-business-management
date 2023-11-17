package dev.gabrielsena.prompt;

import dev.gabrielsena.prompt.client.*;
import dev.gabrielsena.prompt.product.CreateProductPromptOption;
import dev.gabrielsena.prompt.product.ListProductsPromptOption;
import dev.gabrielsena.prompt.product.UpdateProductQuantityPromptOption;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GeneralPrompt {

    private LinkedHashMap<Integer, PromptOptionExecutor> promptOptionExecutors;
    public GeneralPrompt() {
        this.fillPromptOptionExecutors();
        Scanner scanner = new Scanner(System.in);
        this.printPrompt();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("C")) {
                break;
            }
            try {
                int option = Integer.parseInt(line);
                PromptOptionExecutor executor = this.promptOptionExecutors.get(option);
                boolean success = executor.execute();
                for (int i = 0; i < 2 && !success; i++) {
                    success = executor.execute();
                }
                if (!success) {
                    System.out.println("Não foi possível realizar esta operação, retornando ao menu principal");
                    this.printPrompt();
                    continue;
                }
                System.out.println("Prossiga escolhendo uma opção do menu o escreva L para listar a lista de comandos");
            } catch (Exception e) {
                this.printPrompt();
            }
        }
    }

    private void fillPromptOptionExecutors() {
        LinkedHashMap<Integer, PromptOptionExecutor> executors = new LinkedHashMap<>();

        executors.put(1, new AddClientPromptOption());
        executors.put(2, new ListClientsPromptOption());
        executors.put(3, new ViewClientPromptOption());
        executors.put(4, new ScheduleServicePromptOption());
        executors.put(5, new UpdateClientPromptOption());
        executors.put(6, new UpdateClientServiceHistoryPromptOption());
        executors.put(7, new CreateProductPromptOption());
        executors.put(8, new ListProductsPromptOption());
        executors.put(9, new UpdateProductQuantityPromptOption());

        this.promptOptionExecutors = executors;
    }

    private void printPrompt() {
        for (Map.Entry<Integer, PromptOptionExecutor> entry : this.promptOptionExecutors.entrySet()) {
            System.out.println("["+ entry.getKey() +"] "+ entry.getValue().getTitle());
        }
        this.printCancelPrompt();
    }

    private void printCancelPrompt() {
        System.out.println("[C] Para cancelar");
    }
}
