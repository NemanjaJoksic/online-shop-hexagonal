package org.joksin.onlineshop.rdbms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("order")
public class OrderEntity {

    @Id
    private Integer id;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("total_price")
    private Double totalPrice;

    @Column("status_id")
    private Integer statusId;

    @Column("customer_id")
    private Integer customerId;

}
