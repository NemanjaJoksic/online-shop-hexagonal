package org.joksin.onlineshop.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Country {

    SERBIA(1, "Serbia", "SRB"),
    MONTENEGRO(2, "Montenegro", "MNE");

    private final Integer id;
    private final String name;
    private final String isoCode;

}
