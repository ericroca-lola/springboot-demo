package com.ericroca.springbootdemo.service.implementation;

import com.ericroca.springbootdemo.dao.interfaces.IForecastDAO;
import com.ericroca.springbootdemo.model.Forecast;
import com.ericroca.springbootdemo.model.Response;
import com.ericroca.springbootdemo.model.elements.ListElement;
import com.ericroca.springbootdemo.model.elements.MainElement;
import com.ericroca.springbootdemo.service.interfaces.IForecastService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastService implements IForecastService {

    @Autowired
    private IForecastDAO forecastDAO;

    @Override
    public synchronized Forecast addForecast(Forecast forecast) {
        return forecastDAO.addForecast(forecast);
    }

    @Override
    public synchronized Forecast addForecast(String startDate, String startTime,
                                         String endDate, String endTime, float averageTemperature) {

        Forecast forecast = new Forecast(startDate, startTime, endDate, endTime, averageTemperature);
        return forecastDAO.addForecast(forecast);
    }

    @Override
    public List<Forecast> getAllForecasts() {
        return forecastDAO.getAllForecasts();
    }

    @Override
    public float calculateAverageTemperature(String jsonData) {
        ObjectMapper mapper = new ObjectMapper();
        float averageTemperature = 0;
        try {
            Response response = mapper.readValue(jsonData, Response.class);
            List<ListElement> listElements = response.getList();
            for (ListElement listElement : listElements) {
                MainElement mainElement = listElement.getMain();
                averageTemperature += mainElement.getTemp();
            }
            averageTemperature /= response.getCnt();
            averageTemperature = convertKelvinToCelsius(averageTemperature);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return averageTemperature;
    }

    private float convertKelvinToCelsius(float value) {
        return (float) (value - 273.15);
    }

    @Override
    public List<String> parseDate(String jsonData) throws IOException {
        List<String> dateTime = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        Response response = mapper.readValue(jsonData, Response.class);
        List<ListElement> listElements = response.getList();
        LocalDateTime start = listElements.get(0).getDtTxt();
        LocalDateTime end = listElements.get(response.getCnt() - 1).getDtTxt();
        dateTime.add(start.toLocalDate().toString());
        dateTime.add(start.toLocalTime().toString());
        dateTime.add(end.toLocalDate().toString());
        dateTime.add(end.toLocalTime().toString());
        return dateTime;
    }
}
