package dev.gabrielsena.prompt.client.servicehistory;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.product.Product;
import dev.gabrielsena.prompt.LoopPrompt;
import dev.gabrielsena.prompt.product.ProductCommons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SetProductsProvidedService extends LoopPrompt {

    public SetProductsProvidedService(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Object execute(String line) {
        boolean hasInvalid = Arrays.stream(line.split(",")).anyMatch(c -> c.length() > 1 || !Character.isDigit(c.charAt(0)));
        if (hasInvalid) {
            return null;
        }
        List<Integer> productsIds = Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
        return BusinessManagement.getInstance().getStockManager().getProducts().stream().filter(product -> product.getQuantity() > 0 && productsIds.contains(product.getId())).collect(Collectors.toList());
    }

    @Override
    public void printInfos() {
        System.out.println("Lista de produtos:");
        ProductCommons.printProducts(false);
        System.out.println("Digite os produtos, separados por vírgula, exemplo: 1,2,3,4");
        System.out.println("Os produtos que não existirem, serão ignorados.");
    }

    @Override
    public Object start() {
        if (BusinessManagement.getInstance().getStockManager().getProducts().stream().noneMatch(product -> product.getQuantity() > 0)) {
            System.out.println("Não há produtos registrados. Pulando...");
            return new ArrayList<Product>();
        }
        return super.start();
    }
}
