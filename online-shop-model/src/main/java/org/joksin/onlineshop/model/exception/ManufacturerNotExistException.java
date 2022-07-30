package org.joksin.onlineshop.model.exception;

public class ManufacturerNotExistException extends RuntimeException {

    public ManufacturerNotExistException(Integer manufacturerId) {
        super("Manufacturer with id " + manufacturerId + " does not exist");
    }

}
