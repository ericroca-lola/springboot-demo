package com.ericroca.springbootdemo.model.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

class RainElement {

    @JsonProperty("3h")
    private double threeH;

    public RainElement() {
    }

    public RainElement(double threeH) {
        this.threeH = threeH;
    }

    public double getThreeH() {
        return threeH;
    }

    public void setThreeH(double threeH) {
        this.threeH = threeH;
    }
}
