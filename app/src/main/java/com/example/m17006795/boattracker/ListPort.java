package com.example.m17006795.boattracker;

import java.util.ArrayList;

public class ListPort {
    private static ArrayList<Port> listPort = new ArrayList<>();

    public static ArrayList<Port> getListPort() {
        return listPort;
    }

    public static Port searchPortByName (String namePort) {
        for (Port p : listPort)
            if (p.getName().equals(namePort))
                return p;

        return null;
    }

    public static Port searchPortById (Port port) {
        for (Port p : listPort)
            if (port.getId() == port.getId())
                return p;

        return port;
    }
}
