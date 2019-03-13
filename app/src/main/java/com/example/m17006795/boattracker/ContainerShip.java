package com.example.m17006795.boattracker;

import java.io.Serializable;
import java.util.ArrayList;

public class ContainerShip implements Serializable {
    private static ArrayList<ContainerShip> listShips = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void destroyShip() {
        listShips.remove(this);
    }

    public static ArrayList<ContainerShip> getShips () {
        return listShips;
    }

    public ContainerShipType getType() {
        return type;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public Port getPort() {
        return port;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public void setType(ContainerShipType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public ContainerShip searchShip (ContainerShip ship) {
        for (ContainerShip cs : listShips)
            if (ship.getId() == cs.getId())
                return cs;

        return ship;
    }
}
