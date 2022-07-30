package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateManufacturerRequestDTO {

    private final String name;
    private final Integer countryId;

}
