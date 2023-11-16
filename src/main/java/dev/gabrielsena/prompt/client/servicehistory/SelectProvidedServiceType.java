package dev.gabrielsena.prompt.client.servicehistory;

import dev.gabrielsena.prompt.LoopPrompt;

import java.util.Scanner;

public class SelectProvidedServiceType extends LoopPrompt {

    public SelectProvidedServiceType(Scanner scanner) {
        super(scanner);
    }

    @Override
    public String execute(String line) {
        if (!(line.equals("1") || line.equals("2"))) {
            return null;
        }
        return line;
    }

    @Override
    public void printInfos() {
        System.out.println("Para escolher o tipo de serviço prestado, escolha uma das opções:");
        System.out.println("[1] Manicure");
        System.out.println("[2] Pedicure");
    }
}
