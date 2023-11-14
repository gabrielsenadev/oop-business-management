package dev.gabrielsena.product;

public class ProductQuantityChangeError extends Error {

    ProductQuantityChangeError() {
        super("Não é possível realizar esta alteração, pois a solicitação é inválida.");
    }
}
