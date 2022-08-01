package org.joksin.onlineshop.rdbms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("order_item")
public class OrderItemEntity {

    @Id
    private Integer id;

    @Column("quantity")
    private Integer quantity;

    @Column("total_price")
    private Double totalPrice;

    @Column("product_id")
    private Integer productId;

    @Column("order_id")
    private Integer orderId;

}
