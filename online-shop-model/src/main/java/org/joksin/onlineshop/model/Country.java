package org.joksin.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joksin.onlineshop.model.exception.CountryIdNotExistException;

@Getter
@AllArgsConstructor
public enum Country {

    SERBIA(1, "Serbia", "SRB"),
    MONTENEGRO(2, "Montenegro", "MNE");

    private final Integer id;
    private final String name;
    private final String isoCode;

    public static Country of(Integer id) {
        switch (id) {
            case 1: return SERBIA;
            case 2: return MONTENEGRO;
            default:
                throw new CountryIdNotExistException(id);
        }
    }

}
