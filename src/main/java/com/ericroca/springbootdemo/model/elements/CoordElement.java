package com.ericroca.springbootdemo.model.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

class CoordElement {

    @JsonProperty("lat")
    private double lat;
    @JsonProperty("lon")
    private double lon;

    public CoordElement() {
    }

    public CoordElement(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
