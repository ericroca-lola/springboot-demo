package com.ericroca.springbootdemo.controller;

import com.ericroca.springbootdemo.model.Forecast;
import com.ericroca.springbootdemo.service.interfaces.IForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("forecast")
public class ForecastController {

    @Autowired
    private IForecastService forecastService;

    @GetMapping("/list")
    public ResponseEntity<List<Forecast>> getAllForecasts() {
        List<Forecast> list = forecastService.getAllForecasts();
        return new ResponseEntity<List<Forecast>>(list, HttpStatus.OK);
    }
}
