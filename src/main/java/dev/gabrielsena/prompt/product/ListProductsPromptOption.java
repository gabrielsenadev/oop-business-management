package dev.gabrielsena.prompt.product;

import dev.gabrielsena.BusinessManagement;
import dev.gabrielsena.prompt.PromptOptionExecutor;

public class ListProductsPromptOption implements PromptOptionExecutor {
    @Override
    public boolean execute() {
        if (BusinessManagement.getInstance().getStockManager().getProducts().isEmpty()) {
            System.out.println("Não há produtos cadastrados");
            return true;
        }
        ProductCommons.printProducts();
        return true;
    }

    @Override
    public String getTitle() {
        return "Listar produtos";
    }
}
