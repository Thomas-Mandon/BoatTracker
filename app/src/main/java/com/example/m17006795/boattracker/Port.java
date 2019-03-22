package com.example.m17006795.boattracker;

import java.io.Serializable;

public class Port implements Serializable {
    private int id;
    private String name;
    private double latitude;
    private double longitude;

    public Port(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        ListPort.getListPort().add(this);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
