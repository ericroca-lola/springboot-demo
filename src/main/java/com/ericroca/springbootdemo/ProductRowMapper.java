package com.ericroca.springbootdemo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet row, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(row.getInt("ID"));
        product.setName(row.getString("PRODUCT_NAME"));
        return product;
    }
}
