package org.joksin.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joksin.onlineshop.model.exception.OrderStatusNotExistException;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PREPARING(1, "PREPARING"),
    SENT(2, "SENT"),
    DELIVERED(3, "DELIVERED");

    private final Integer id;
    private final String name;

    public static OrderStatus of(Integer id) {
        switch (id) {
            case 1: return PREPARING;
            case 2: return SENT;
            case 3: return DELIVERED;
            default:
                throw new OrderStatusNotExistException(id);
        }
    }

}
