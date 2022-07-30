package org.joksin.onlineshop.api.request;

import lombok.Builder;
import lombok.Getter;
import org.joksin.onlineshop.model.Country;

@Getter
@Builder
public class CreateManufacturerRequest {

    private final String name;
    private final Country country;

}
