package com.example.m17006795.boattracker;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ShipBase {
    private static final String COLLECTION_NAME = "bateaux";

    //Accéder a la collection firebase

    public static CollectionReference getBateauxCollection() {
        return FirebaseFirestore.getInstance().collection("bateaux");
    }

    //Créer un nouveau bateau dans la base

    public static Task<Void> createShip(int id, String name, String captainName) {
        ContainerShipBuilder shipToCreate = new ContainerShipBuilder();
        shipToCreate.setId(id);
        shipToCreate.setName(name);
        shipToCreate.setCaptainName(captainName);
        return ShipBase.getBateauxCollection().document("id").set(shipToCreate);
    }
}
