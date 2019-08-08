package com.ericroca.springbootdemo.model.elements;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

public class ListElement {

    @JsonProperty("dt")
    private long dt;
    @JsonProperty("main")
    private MainElement main;
    @JsonProperty("weather")
    private List<WeatherElement> weather;
    @JsonProperty("clouds")
    private CloudElement clouds;
    @JsonProperty("wind")
    private WindElement wind;
    @JsonProperty("rain")
    private RainElement rain;
    @JsonProperty("sys")
    private SysElement sys;
    @JsonProperty(value = "dt_txt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dtTxt;

    public ListElement() {
    }

    public ListElement(long dt, MainElement main, List<WeatherElement> weather, CloudElement clouds, WindElement wind,
                       RainElement rain, SysElement sys, LocalDateTime dtTxt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dtTxt = dtTxt;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public MainElement getMain() {
        return main;
    }

    public void setMain(MainElement main) {
        this.main = main;
    }

    public List<WeatherElement> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherElement> weather) {
        this.weather = weather;
    }

    public CloudElement getClouds() {
        return clouds;
    }

    public void setClouds(CloudElement clouds) {
        this.clouds = clouds;
    }

    public WindElement getWind() {
        return wind;
    }

    public void setWind(WindElement wind) {
        this.wind = wind;
    }

    public RainElement getRain() {
        return rain;
    }

    public void setRain(RainElement rain) {
        this.rain = rain;
    }

    public SysElement getSys() {
        return sys;
    }

    public void setSys(SysElement sys) {
        this.sys = sys;
    }

    public LocalDateTime getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(LocalDateTime dtTxt) {
        this.dtTxt = dtTxt;
    }
}
