package dev.gabrielsena.prompt.product;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.product.Product;
import dev.gabrielsena.prompt.PromptOptionExecutor;
import java.util.Scanner;

public class CreateProductPromptOption implements PromptOptionExecutor {

    @Override
    public boolean execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do produto: ");
            String nameInput = scanner.nextLine();
            System.out.print("\nDigite a quantidade do produto:");
            int quantityInput = Integer.parseInt(scanner.nextLine());

            int id = BusinessManagement.getInstance().getStockManager().getProducts().size() + 1;
            Product product = new Product(id, nameInput, quantityInput);
            BusinessManagement.getInstance().getStockManager().addProduct(product);
            System.out.println("Produto adicionado");
            return true;
        } catch (Exception e) {
            if (e instanceof  NumberFormatException) {
                System.out.println("Digite um número válido.");
                return false;
            }
        }
        return true;
    }

    @Override
    public String getTitle() {
        return "Criar produto";
    }
}
