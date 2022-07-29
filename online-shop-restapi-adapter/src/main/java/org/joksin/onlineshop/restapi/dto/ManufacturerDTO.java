package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;
import org.joksin.onlineshop.model.Country;

@Getter
@Builder
public class ManufacturerDTO {

    private final Integer id;
    private final String name;
    private final Country country;
    
}
