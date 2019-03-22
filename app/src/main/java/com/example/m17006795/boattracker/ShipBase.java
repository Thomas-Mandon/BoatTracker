package com.example.m17006795.boattracker;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ShipBase extends AppCompatActivity {
    private static final String COLLECTION_NAME = "bateaux";
    private ContainerShip bateau;

    //Accéder a la collection firebase

    public static CollectionReference getBateauxCollection() {
        return FirebaseFirestore.getInstance().collection("bateaux");
    }





}
