package com.ericroca.springbootdemo.service.interfaces;

import com.ericroca.springbootdemo.model.Forecast;

import java.util.List;

public interface IForecastService {

    List<Forecast> getAllForecasts();
}