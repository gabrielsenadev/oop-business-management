package dev.gabrielsena.prompt.client.servicehistory;

import dev.gabrielsena.prompt.LoopPrompt;

import java.util.Scanner;

public class SetCostProvidedService extends LoopPrompt {

    public SetCostProvidedService(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Object execute(String line) {
        try {
            return Float.parseFloat(line);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void printInfos() {
        System.out.println("Digite o valor, em formato americano, do serviço prestado:");
        System.out.print("R$: ");
    }
}
