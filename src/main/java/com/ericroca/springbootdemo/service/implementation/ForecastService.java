package com.ericroca.springbootdemo.service.implementation;

import com.ericroca.springbootdemo.dao.interfaces.IForecastDAO;
import com.ericroca.springbootdemo.model.Forecast;
import com.ericroca.springbootdemo.service.interfaces.IForecastService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ForecastService implements IForecastService {

    @Autowired
    private IForecastDAO forecastDAO;

    @Override
    public synchronized void addForecast(Forecast forecast) {
        forecastDAO.addForecast(forecast);
    }

    @Override
    public synchronized void addForecast(String startDate, String startTime,
                                         String endDate, String endTime, float averageTemperature) {

        Forecast forecast = new Forecast(startDate, startTime, endDate, endTime, averageTemperature);
        forecastDAO.addForecast(forecast);
    }

    @Override
    public List<Forecast> getAllForecasts() {
        return forecastDAO.getAllForecasts();
    }

    @Override
    public float calculateAverageTemperature(JsonNode listNode) {
        float averageTemperature = 0;
        for (int i = 0; i < listNode.size(); ++i) {
            averageTemperature += listNode.get(i).get("main").get("temp").floatValue();
        }
        averageTemperature = (float) ((averageTemperature / listNode.size()) - 273.15);
        return averageTemperature;
    }

    @Override
    public List<String> parseDate(JsonNode listNode) {
        List<String> dateTime = new ArrayList<>();
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(listNode.get(0).get("dt_txt").asText());
            dateTime.add(new SimpleDateFormat("yyyy-MM-dd").format(start));
            dateTime.add(new SimpleDateFormat("HH:mm:ss").format(start));

            Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(listNode.get(listNode.size() - 1).get("dt_txt").asText());
            dateTime.add(new SimpleDateFormat("yyyy-MM-dd").format(end));
            dateTime.add(new SimpleDateFormat("HH:mm:ss").format(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }
}
