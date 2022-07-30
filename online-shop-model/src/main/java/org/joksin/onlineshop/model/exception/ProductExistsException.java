package org.joksin.onlineshop.model.exception;

public class ProductExistsException extends RuntimeException {

    public ProductExistsException(String productName, Integer manufacturerId) {
        super("Product with name " + productName + " of manufacturer [ID: " + manufacturerId + "] already exists");
    }

}
