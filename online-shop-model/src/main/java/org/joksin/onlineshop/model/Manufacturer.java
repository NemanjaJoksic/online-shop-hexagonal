package org.joksin.onlineshop.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Manufacturer {

    private final Integer id;
    private final String name;
    private final Country country;

    public static Manufacturer of(Integer manufacturerId) {
        return Manufacturer.builder()
                .id(manufacturerId)
                .build();
    }

}
