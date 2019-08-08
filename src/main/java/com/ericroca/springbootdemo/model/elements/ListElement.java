package com.ericroca.springbootdemo.model.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("dt_txt")
    private String dtTxt;

    public ListElement() {
    }

    public ListElement(long dt, MainElement main, List<WeatherElement> weather, CloudElement clouds, WindElement wind,
                       RainElement rain, SysElement sys, String dtTxt) {
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

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }
}
