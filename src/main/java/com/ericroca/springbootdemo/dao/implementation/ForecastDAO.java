package com.ericroca.springbootdemo.dao.implementation;

import com.ericroca.springbootdemo.dao.interfaces.IForecastDAO;
import com.ericroca.springbootdemo.model.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ForecastDAO implements IForecastDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ForecastDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Forecast> getAllForecasts() {
        String sql = "SELECT id, startDate, startTime, endDate, endTime, averageTemperature FROM forecast";
        RowMapper<Forecast> rowMapper = new BeanPropertyRowMapper<>(Forecast.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
