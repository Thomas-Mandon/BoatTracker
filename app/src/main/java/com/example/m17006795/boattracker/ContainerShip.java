package com.example.m17006795.boattracker;

import android.support.v4.util.ArrayMap;

import com.google.protobuf.Any;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

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

    public ContainerShip(int id, String name, String captainName, float latitude, float longitude, String namePort, ContainerShipType type, Container[] containers) {
        this.id = id;
        this.name = name;
        this.captainName = captainName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.containers = containers;

        this.port = ListPort.searchPortByName(namePort);

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

    public Container[] getContainers() {
        return containers;
    }

    public ContainerShip searchShip (ContainerShip ship) {
        for (ContainerShip cs : listShips)
            if (ship.getId() == cs.getId())
                return cs;

        return ship;
    }

    public ArrayMap<String, String> createMap() {
        ArrayMap<String, String> map = new ArrayMap<>();
         map.put("name", this.name);
         map.put ("captainName", this.captainName);
         return  map;
    }

    public void moveContainerOnOtherShip (Container container, ContainerShip bateauDestination) {

    }
}
