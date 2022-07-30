package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ManufacturerDTO {

    private final Integer id;
    private final String name;
    private final CountryDTO country;
    
}
