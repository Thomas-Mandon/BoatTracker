package com.example.m17006795.boattracker;

public class PortBuilder {
    private int id;
    private String name;
    private double latitude;
    private double longitude;

    public Port build() {
        return new Port(id, name, latitude, longitude);
    }

    public PortBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PortBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PortBuilder setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public PortBuilder setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}
