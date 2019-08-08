package com.ericroca.springbootdemo.model;

import com.ericroca.springbootdemo.model.elements.ListElement;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Response {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private double message;
    @JsonProperty("cnt")
    private int cnt;
    @JsonProperty("list")
    private List<ListElement> list;

    public Response() {
    }

    public Response(String cod, double message, int cnt, List<ListElement> list) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
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
}
