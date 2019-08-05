package com.ericroca.springbootdemo.model;

import java.sql.Time;
import java.sql.Date;

public class Forecast {
    private int id;
    private Date day;
    private Time hour;
    private float temperature;

    public Forecast(int id, Date day, Time hour, float temperature) {
        this.id = id;
        this.day = day;
        this.hour = hour;
        this.temperature = temperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
