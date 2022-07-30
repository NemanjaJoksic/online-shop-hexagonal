package org.joksin.onlineshop.model.exception;

public class CountryNotExistException extends RuntimeException {

    public CountryNotExistException(Integer countryId) {
        super("Country with ID " + countryId + " does not exist");
    }

}
