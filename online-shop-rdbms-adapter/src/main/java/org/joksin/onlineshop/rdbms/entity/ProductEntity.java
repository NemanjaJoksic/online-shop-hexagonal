package org.joksin.onlineshop.rdbms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("product")
public class ProductEntity {

    @Id
    private Integer id;

    @Column("name")
    private String name;

    @Column("price")
    private Double price;

    @Column("last_updated")
    LocalDateTime lastUpdated;

    @Column("type_id")
    private Integer typeId;

    @Column("manufacturer_id")
    private Integer manufacturerId;

    @Transient
    private ManufacturerEntity manufacturer;

}
