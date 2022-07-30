package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;
import org.joksin.onlineshop.model.Country;

@Getter
@Builder
public class CustomerDTO {

    private final Integer id;
    private final String name;
    private final String surname;
    private final String email;
    private final Country country;

}
