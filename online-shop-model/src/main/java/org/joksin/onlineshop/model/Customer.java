package org.joksin.onlineshop.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {

    private final Integer id;
    private final String name;
    private final String surname;
    private final String email;
    private final Country country;

    public static Customer of(Integer customerId) {
        return Customer.builder()
                .id(customerId)
                .build();
    }

}
