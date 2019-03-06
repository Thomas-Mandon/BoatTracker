package com.example.m17006795.boattracker;

public class ContainerShipBuilder {
    private int id = 0;
    private String name = "";
    private String captainName = "";
    private float latitude = 0;
    private float longitude = 0;
    private Port port = new Port(0, "", 0, 0);
    private ContainerShipType type = new ContainerShipType();
    private Container[] containers = new Container[50];

    public ContainerShip build() {
        return new ContainerShip(id, name, captainName, latitude, longitude, port, type, containers);
    }

    public ContainerShipBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ContainerShipBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContainerShipBuilder setCaptainName(String captainName) {
        this.captainName = captainName;
        return this;
    }

    public ContainerShipBuilder setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public ContainerShipBuilder setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public ContainerShipBuilder setPort(Port port) {
        this.port = port;
        return this;
    }

    public ContainerShipBuilder setType(ContainerShipType type) {
        this.type = type;
        return this;
    }

    public ContainerShipBuilder setContainers(Container[] containers) {
        this.containers = containers;
        return this;
    }
}