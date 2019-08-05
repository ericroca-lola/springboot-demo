package com.ericroca.springbootdemo.service.implementation;

import com.ericroca.springbootdemo.dao.interfaces.IForecastDAO;
import com.ericroca.springbootdemo.model.Forecast;
import com.ericroca.springbootdemo.service.interfaces.IForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Forecast> getAllForecasts() {
        return forecastDAO.getAllForecasts();
    }
}
