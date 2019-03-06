package com.example.m17006795.boattracker;

import java.io.Serializable;

public class Container implements Serializable {
    private int id;
    private int length;
    private int height;
    private int width;

    public Container(int id, int length, int height, int width) {
        this.id = id;
        this.length = length;
        this.height = height;
        this.width = width;
    }
}
