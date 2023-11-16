package dev.gabrielsena.prompt;

import dev.gabrielsena.prompt.client.*;

import java.util.Hashtable;
import java.util.Scanner;

public class GeneralPrompt {

    private Hashtable<Integer, PromptOptionExecutor> promptOptionExecutors;
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
        Hashtable<Integer, PromptOptionExecutor> executors = new Hashtable<>();

        executors.put(1, new AddClientPromptOption());
        executors.put(2, new ViewClientPromptOption());
        executors.put(3, new ScheduleServicePromptOption());
        executors.put(4, new UpdateClientPromptOption());
        executors.put(5, new UpdateClientServiceHistoryPromptOption());

        this.promptOptionExecutors = executors;
    }

    private void printPrompt() {
        System.out.println("Escolha as seguintes opções para continuar:");
        System.out.println("--- CLIENTE ---");
        System.out.println("[1] Adicionar cliente");
        System.out.println("[2] Visualizar cliente");
        System.out.println("[3] Agendar serviço para o cliente");
        
        System.out.println("[4] Atualizar cliente");
        System.out.println("[5] Inserir serviço prestado ao cliente");
        System.out.println("[6] Listar clientes");
        System.out.println("--- LOJA ---");
        System.out.println("[7] Cadastrar produto");
        System.out.println("[8] Listar produtos");
        System.out.println("[9] Atualizar quantidade de um produto");
        this.printCancelPrompt();
    }

    private void printCancelPrompt() {
        System.out.println("[C] Para cancelar");
    }
}
