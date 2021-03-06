package com.ericroca.springbootdemo.dao.interfaces;

import com.ericroca.springbootdemo.model.Forecast;

import java.util.List;

public interface IForecastDAO {

    Forecast addForecast(Forecast forecast);

    List<Forecast> getAllForecasts();
}
