package org.joksin.onlineshop.restapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.model.exception.CountryIdNotExistException;
import org.joksin.onlineshop.model.exception.ManufacturerNameExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice(basePackages = "org.joksin.onlineshop.restapi")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {
            ManufacturerNameExistsException.class,
            CountryIdNotExistException.class
    })
    public ResponseEntity<ApiErrorResponse> handleBadRequestException(Throwable t) {
        log.info(t.getMessage());
        return new ResponseEntity<>(ApiErrorResponse.of(t.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorResponse> unexpectedException(Throwable t) {
        log.error(t.getMessage());
        return new ResponseEntity<>(ApiErrorResponse.of("Unexpected exception has occured", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
