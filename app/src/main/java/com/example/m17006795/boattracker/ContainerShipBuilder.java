package com.example.m17006795.boattracker;

import java.util.ArrayList;

public class ContainerShipBuilder {
    private int id = 0;
    private String name = "";
    private String captainName = "";
    private float latitude = 0;
    private float longitude = 0;
    private Port port = new Port(0,"Port_par_defaut",0,0);
    private ContainerShipType type = new ContainerShipType(0, "", 0, 0, 0);
    private ArrayList<Container> containers = new ArrayList<>();

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

    public ContainerShipBuilder setPort(Port namePort) {
        this.port = namePort;
        return this;
    }

    public ContainerShipBuilder setType(ContainerShipType type) {
        this.type = type;
        return this;
    }

    public ContainerShipBuilder setContainers(Container c) {
        this.containers.add(c);
        return this;
    }
}
