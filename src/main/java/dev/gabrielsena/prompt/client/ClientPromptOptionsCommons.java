package dev.gabrielsena.prompt.client;

import java.util.Scanner;

public class ClientPromptOptionsCommons {

    public static String requestClientName(Scanner scanner) {
        System.out.println("Digite o nome do cliente:");
        return scanner.nextLine();
    }

    public static String requestClientPhoneNumber(Scanner scanner) {
        System.out.println("Agora digite o número de telefone:");
        return scanner.nextLine();
    }
}
