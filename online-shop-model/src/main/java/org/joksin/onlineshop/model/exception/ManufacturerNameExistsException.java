package org.joksin.onlineshop.model.exception;

public class ManufacturerNameExistsException extends RuntimeException {

    public ManufacturerNameExistsException(String manufacturerName) {
        super("Manufacturer with name " + manufacturerName + " already exists");
    }

}
