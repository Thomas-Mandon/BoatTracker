package com.example.m17006795.boattracker;

import java.io.Serializable;

public class ContainerShipType implements Serializable {
    private int id;
    private String name;
    private int length;
    private int height;
    private int width;

    public ContainerShipType(int id, String name, int length, int height, int width) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public String getName() {
        return name;
    }
}
