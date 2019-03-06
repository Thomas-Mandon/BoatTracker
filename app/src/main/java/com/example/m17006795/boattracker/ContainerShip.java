package com.example.m17006795.boattracker;

import java.util.ArrayList;
import java.util.List;

public class ContainerShip {
    private static List<ContainerShip> listShips = new ArrayList<>();

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

        listShips.add(this);
    }

    public void destroyShip() {
        listShips.remove(this);
    }

    public List<ContainerShip> getShips () {
        return listShips;
    }
}
