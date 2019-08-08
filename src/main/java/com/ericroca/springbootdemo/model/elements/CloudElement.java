package com.ericroca.springbootdemo.model.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

class CloudElement {

    @JsonProperty("all")
    private int all;

    public CloudElement() {
    }

    public CloudElement(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
