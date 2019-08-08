package com.ericroca.springbootdemo.exception;

public class DateNotFoundException extends RuntimeException {

    public DateNotFoundException(String url) {
        super("No date found at address: " + url);
    }
}
