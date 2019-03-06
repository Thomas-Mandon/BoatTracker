package com.example.m17006795.boattracker;

public class ContainerShip {
    private int id;
    private String name;
    private String captainName;
    private float latitude;
    private float longitude;
    private Port port;
    private ContainerShipType type;
    private Container[] containers;

    public ContainerShip(int id, String name, String captainName, float latitude, float longitude, Port port, ContainerShipType type, Container[] containers) {
        this.id = id;
        this.name = name;
        this.captainName = captainName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.port = port;
        this.type = type;
        this.containers = containers;
    }
}
