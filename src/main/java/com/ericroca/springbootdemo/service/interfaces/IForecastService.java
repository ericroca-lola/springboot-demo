package com.ericroca.springbootdemo.service.interfaces;

import com.ericroca.springbootdemo.model.Forecast;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface IForecastService {

    Forecast addForecast(Forecast forecast);

    Forecast addForecast(String startDate, String startTime, String endDate, String endTime, float averageTemperature);

    List<Forecast> getAllForecasts();

    float calculateAverageTemperature(String jsonData);

    List<String> parseDate(String jsonData);
}
