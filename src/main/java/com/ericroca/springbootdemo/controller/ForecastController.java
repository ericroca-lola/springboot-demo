package com.ericroca.springbootdemo.controller;

import com.ericroca.springbootdemo.model.Forecast;
import com.ericroca.springbootdemo.service.interfaces.IForecastService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("forecast")
public class ForecastController {

    @Autowired
    private IForecastService forecastService;

    @GetMapping("fetch")
    public ResponseEntity<String> fetch() throws IOException, ParseException {
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=681290&APPID=71ef08b523a231385d9b8083d2e2ec3d";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JsonNode listNode = new ObjectMapper().readTree(response).get("list");

        float averageTemperature = 0;
        for (int i = 0; i < listNode.size(); ++i) {
            averageTemperature += listNode.get(i).get("main").get("temp").floatValue();
        }
        averageTemperature = (float) ((averageTemperature / listNode.size()) - 273.15);

        Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(listNode.get(0).get("dt_txt").asText());
        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(start);
        String startTime = new SimpleDateFormat("HH:mm:ss").format(start);

        Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(listNode.get(listNode.size() - 1).get("dt_txt").asText());
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(end);
        String endTime = new SimpleDateFormat("HH:mm:ss").format(end);

        Forecast forecast = new Forecast(startDate, startTime, endDate, endTime, averageTemperature);

        forecastService.addForecast(forecast);

        return new ResponseEntity<>("Fetched from API!", HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<Forecast>> getAllForecasts() {
        List<Forecast> list = forecastService.getAllForecasts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
