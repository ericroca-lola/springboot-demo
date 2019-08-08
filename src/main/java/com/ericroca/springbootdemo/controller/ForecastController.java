package com.ericroca.springbootdemo.controller;

import com.ericroca.springbootdemo.exception.DateNotFoundException;
import com.ericroca.springbootdemo.model.Forecast;
import com.ericroca.springbootdemo.service.interfaces.IForecastService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("forecast")
public class ForecastController {

    @Autowired
    private IForecastService forecastService;

    @GetMapping("fetch")
    public ResponseEntity<List<Forecast>> fetch() {
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=681290&APPID=71ef08b523a231385d9b8083d2e2ec3d";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        float averageTemperature = forecastService.calculateAverageTemperature(response);

        List<String> dateTime;

        try {
            dateTime = forecastService.parseDate(response);
        } catch (IOException e) {
            throw new DateNotFoundException(url);
        }

        Forecast forecast = forecastService.addForecast(dateTime.get(0), dateTime.get(1), dateTime.get(2), dateTime.get(3),
                averageTemperature);

        return new ResponseEntity<>(Arrays.asList(forecast), HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<Forecast>> getAllForecasts() {
        List<Forecast> list = forecastService.getAllForecasts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
