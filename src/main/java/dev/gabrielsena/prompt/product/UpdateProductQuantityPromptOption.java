package dev.gabrielsena.prompt.product;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.product.Product;
import dev.gabrielsena.prompt.PromptOptionExecutor;

import java.util.Scanner;

public class UpdateProductQuantityPromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o identificador de um produto: ");
            int idInput = Integer.parseInt(scanner.nextLine());
            if (BusinessManagement.getInstance().getStockManager().getProducts().stream().noneMatch(c -> c.getId() == idInput)) {
                System.out.println("Produto não encontrado.");
                return false;
            }
            System.out.print("\nDigite a quantidade do produto:");
            int quantityInput = Integer.parseInt(scanner.nextLine());
            Product product = BusinessManagement.getInstance().getStockManager().getProducts().stream().filter(c -> c.getId() == idInput).findFirst().get();
            product.setQuantity(quantityInput);
            System.out.println("Produto atualizado.");
            return true;
        } catch (Exception e) {
            if (e instanceof  NumberFormatException) {
                System.out.println("Digite um número ou identificador válido.");
                return false;
            }
            System.out.println("Não foi possível realizar esta operação.");
            return false;
        }
    }

    @Override
    public String getTitle() {
        return "Atualizar quantidade do produto";
    }
}
