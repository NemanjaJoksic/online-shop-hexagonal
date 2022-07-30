package org.joksin.onlineshop.model.exception;

public class ManufacturerExistsException extends RuntimeException {

    public ManufacturerExistsException(String manufacturerName) {
        super("Manufacturer with name " + manufacturerName + " already exists");
    }

}
