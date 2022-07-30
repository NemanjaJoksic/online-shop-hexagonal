package org.joksin.onlineshop.restapi.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ApiErrorResponse {

    private final Integer status;
    private final String message;

    public static ApiErrorResponse of(String message, HttpStatus httpStatus) {
        return ApiErrorResponse.builder()
                .message(message)
                .status(httpStatus.value())
                .build();
    }

}
