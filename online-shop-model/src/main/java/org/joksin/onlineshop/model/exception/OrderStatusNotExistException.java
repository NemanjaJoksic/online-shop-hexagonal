package org.joksin.onlineshop.model.exception;

public class OrderStatusNotExistException extends RuntimeException {

    public OrderStatusNotExistException(Integer orderStatusId) {
        super("OrderStatus with ID " + orderStatusId + " does not exist");
    }

}
