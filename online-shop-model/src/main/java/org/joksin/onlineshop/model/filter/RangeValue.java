package org.joksin.onlineshop.model.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RangeValue<T> {

    private final T from;
    private final T to;

}
