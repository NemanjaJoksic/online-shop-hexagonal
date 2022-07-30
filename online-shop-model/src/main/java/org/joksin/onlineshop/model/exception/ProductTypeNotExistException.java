package org.joksin.onlineshop.model.exception;

public class ProductTypeNotExistException extends RuntimeException {

    public ProductTypeNotExistException(Integer productTypeId) {
        super("ProductType with ID " + productTypeId + " does not exist");
    }

}
