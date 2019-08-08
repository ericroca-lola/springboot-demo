package com.ericroca.springbootdemo.model.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityElement {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("coord")
    private CoordElement coord;
    @JsonProperty("country")
    private String country;
    @JsonProperty("timezone")
    private int timezone;

    public CityElement() {
    }

    public CityElement(int id, String name, CoordElement coord, String country, int timezone) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordElement getCoord() {
        return coord;
    }

    public void setCoord(CoordElement coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }
}
