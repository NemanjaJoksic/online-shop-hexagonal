package org.joksin.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joksin.onlineshop.model.exception.ProductTypeNotExistException;

@Getter
@AllArgsConstructor
public enum ProductType {

    FRUIT(1, "fruit"),
    DRINK(2, "drink"),
    FOOD(3, "food"),
    MILK_PRODUCT(4, "milk product"),
    SWEET(5, "sweet");

    private final Integer id;
    private final String name;

    public static ProductType of(Integer id) {
        switch (id) {
            case 1: return FRUIT;
            case 2: return DRINK;
            case 3: return FOOD;
            case 4: return MILK_PRODUCT;
            case 5: return SWEET;
            default:
                throw new ProductTypeNotExistException(id);
        }
    }

}
