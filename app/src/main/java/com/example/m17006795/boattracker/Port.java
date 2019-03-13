package com.example.m17006795.boattracker;

import java.io.Serializable;

public class Port implements Serializable {
    private int id;
    private String name;
    private float latitude;
    private float longitude;

    public Port(int id, String name, float latitude, float longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
