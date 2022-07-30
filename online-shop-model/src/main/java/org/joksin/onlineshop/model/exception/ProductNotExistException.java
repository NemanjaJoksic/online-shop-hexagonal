package org.joksin.onlineshop.model.exception;

public class ProductNotExistException extends RuntimeException {

    public ProductNotExistException(Integer productId) {
        super("Product with name " + productId + " does not exist");
    }

}
