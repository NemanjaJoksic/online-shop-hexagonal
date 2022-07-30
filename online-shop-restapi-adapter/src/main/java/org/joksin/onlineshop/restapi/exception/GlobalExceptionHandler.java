package org.joksin.onlineshop.restapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.joksin.onlineshop.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice(basePackages = "org.joksin.onlineshop.restapi")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {
            ManufacturerExistsException.class,
            ManufacturerNotExistException.class,
            CountryNotExistException.class,
            ProductExistsException.class,
            ProductNotExistException.class
    })
    public ResponseEntity<ApiErrorResponse> handleConflictException(Throwable t) {
        log.info(t.getMessage());
        return new ResponseEntity<>(ApiErrorResponse.of(t.getMessage(), HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorResponse> unexpectedException(Throwable t) {
        log.error(t.getMessage(), t);
        return new ResponseEntity<>(ApiErrorResponse.of("Unexpected exception has occured", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
