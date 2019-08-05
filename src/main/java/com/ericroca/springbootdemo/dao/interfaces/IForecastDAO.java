package com.ericroca.springbootdemo.dao.interfaces;

import com.ericroca.springbootdemo.model.Forecast;

import java.util.List;

public interface IForecastDAO {

    void addForecast(Forecast forecast);

    List<Forecast> getAllForecasts();
}
