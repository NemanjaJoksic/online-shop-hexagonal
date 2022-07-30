package org.joksin.onlineshop.rdbms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("manufacturer")
public class ManufacturerEntity {

    @Id
    private Integer id;

    @Column("name")
    private String name;

    @Column("country_id")
    private Integer countryId;

}
