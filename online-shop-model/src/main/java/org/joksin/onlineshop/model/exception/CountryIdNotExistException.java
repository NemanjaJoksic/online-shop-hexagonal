package org.joksin.onlineshop.model.exception;

public class CountryIdNotExistException extends RuntimeException {

    public CountryIdNotExistException(Integer countryId) {
        super("Country with ID " + countryId + " does not exist");
    }

}
