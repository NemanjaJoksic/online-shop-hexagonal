package org.joksin.onlineshop.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductTypeDTO {

    private final Integer id;
    private final String name;

}
