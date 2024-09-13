package com.automation.api.constant;

public enum APIEndpoint {

    Base_URL("https://restful-booker.herokuapp.com"),
    AUTH_ENDPOINT("/auth/"),
    BOOKING_ENDPOINT("/booking/");

    private String endpoint;

    APIEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String get(){
        return endpoint;
    }
}


