package com.ericroca.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProductDAO implements IProductDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT ID, PRODUCT_NAME FROM PRODUCT";
        RowMapper<Product> rowMapper = new ProductRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
