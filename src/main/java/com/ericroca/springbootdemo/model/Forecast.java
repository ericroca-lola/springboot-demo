package com.ericroca.springbootdemo.model;

public class Forecast {
    private int id;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private float averageTemperature;

    public Forecast() {
    }

    public Forecast(int id, String startDate, String startTime, String endDate, String endTime, float averageTemperature) {
        this.id = id;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.averageTemperature = averageTemperature;
    }

    public Forecast(String startDate, String startTime, String endDate, String endTime, float averageTemperature) {
        this.id = -1;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.averageTemperature = averageTemperature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public float getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(float averageTemperature) {
        this.averageTemperature = averageTemperature;
    }
}
