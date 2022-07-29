package org.joksin.onlineshop.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Manufacturer {

    private final Integer id;
    private final String name;
    private final Country country;

}
