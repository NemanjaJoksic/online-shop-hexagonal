package org.joksin.onlineshop.rdbms.entity.mapper;

import org.joksin.onlineshop.model.ProductType;
import org.joksin.onlineshop.rdbms.entity.ProductEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductEntityRowMapper implements RowMapper<ProductEntity> {

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(rs.getInt("id"));
        productEntity.setName(rs.getString("name"));
        productEntity.setTypeId(rs.getInt("type_id"));
        productEntity.setPrice(rs.getDouble("price"));
        productEntity.setLastUpdated(rs.getTimestamp("last_updated").toLocalDateTime());
        productEntity.setManufacturerId(rs.getInt("manufacturer_id"));
        return productEntity;
    }

}
