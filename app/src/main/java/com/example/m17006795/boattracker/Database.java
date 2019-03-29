package com.example.m17006795.boattracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Database {
    String TAG = "MainActivityDB";


    public ArrayMap<String, Object> addContainerShip (FirebaseFirestore db, ContainerShip ship) {

        ArrayMap<String, Object> map = new ArrayMap<>();
        map.put("name", ship.getName());
        map.put ("captainName", ship.getCaptainName());
        map.put("latitude", ship.getLatitude());
        map.put("longitude", ship.getLongitude());

        db.collection("bateaux").add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference docRef) {
                        Log.d (TAG, "DocumentSnapshot successfully written !!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w (TAG, "Error writing document", e);
                    }
                });

        return  map;
    }

    public ArrayMap<String, Object> addPort (FirebaseFirestore db, Port port) {

        ArrayMap<String, Object> mapPorts = new ArrayMap<>();
        mapPorts.put("name", port.getName());
        mapPorts.put("latitude", port.getLatitude());
        mapPorts.put("longitude", port.getLongitude());

        db.collection("ports").add(mapPorts)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference docRef) {
                        Log.d (TAG, "DocumentSnapshot successfully written !!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w (TAG, "Error writing document", e);
                    }

                });

        return  mapPorts;
    }
}
