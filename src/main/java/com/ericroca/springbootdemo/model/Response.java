package com.ericroca.springbootdemo.model;

import com.ericroca.springbootdemo.model.elements.CityElement;
import com.ericroca.springbootdemo.model.elements.ListElement;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private double message;
    @JsonProperty("cnt")
    private int cnt;
    @JsonProperty("list")
    private List<ListElement> list;
    @JsonProperty("city")
    private CityElement city;

    public Response() {
    }

    public Response(String cod, double message, int cnt, List<ListElement> list, CityElement city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ListElement> getList() {
        return list;
    }

    public void setList(List<ListElement> list) {
        this.list = list;
    }

    public CityElement getCity() {
        return city;
    }

    public void setCity(CityElement city) {
        this.city = city;
    }
}
