package dev.gabrielsena.prompt.product;

import dev.gabrielsena.BusinessManagement;

public class ProductCommons {

    public static void printProducts(boolean printEmpty) {
        System.out.println("ID    NOME    QUANTIDADE");
        BusinessManagement.getInstance().getStockManager().getProducts().stream().filter(p -> !printEmpty || p.getQuantity() > 0).map(p -> p.getId() + "    "+ p.getName()+"    "+p.getQuantity()).forEach(System.out::println);
    }

    public static void printProducts() {
        printProducts(true);
    }
}
