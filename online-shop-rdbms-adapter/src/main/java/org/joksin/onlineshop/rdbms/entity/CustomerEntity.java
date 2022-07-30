package org.joksin.onlineshop.rdbms.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("customer")
public class CustomerEntity {

    @Id
    private Integer id;

    @Column("name")
    private String name;

    @Column("surname")
    private String surname;

    @Column("email")
    private String email;

    @Column("country_id")
    private Integer countryId;

}
