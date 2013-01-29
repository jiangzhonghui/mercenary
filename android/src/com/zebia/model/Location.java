package com.zebia.model;


import java.io.Serializable;

public class Location implements Serializable {
    private double latitude;
    private double longitude;
    private String address;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }
}

