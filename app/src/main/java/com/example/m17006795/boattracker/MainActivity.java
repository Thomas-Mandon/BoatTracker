package com.example.m17006795.boattracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivityDB";
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firestore.collection("bateaux")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Log.d(TAG, "Bateaux : " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "No such document", task.getException());
                        }
                    }
                });

        firestore.collection("ports")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document2 : task.getResult()) {

                                Log.d(TAG, "Ports : " + document2.getData());
                            }
                        }
                        else {
                            Log.w(TAG, "No such document", task.getException());
                        }
                    }
                });

        new PortBuilder()
                .setId(0)
                .setName("Pearl Harbor")
                .setLatitude(21.339884)
                .setLongitude(-157.970901)
                .build();
        new PortBuilder()
                .setId(0)
                .setName("Vieux-Port")
                .setLatitude(43.295175)
                .setLongitude(5.372672)
                .build();
        new PortBuilder()
                .setId(0)
                .setName("Le Havre")
                .setLatitude(49.4938)
                .setLongitude(0.1077)
                .build();
        new PortBuilder()
                .setId(0)
                .setName("Port de Hong Kong")
                .setLatitude(22.333332)
                .setLongitude(114.1166662)
                .build();

        ContainerShipType petrolier = new ContainerShipType(1, "petrolier", 140, 150, 200);

        if (ContainerShip.getShips().isEmpty()) {
            new ContainerShipBuilder().setName("La Voix")
                    .setId(0)
                    .setCaptainName("John Adams")
                    .setType(petrolier)
                    .setLatitude(3.66f)
                    .setLongitude(3.66f)
                    .setPort("Pearl Harbor")
                    .build();
            new ContainerShipBuilder()
                    .setId(1)
                    .setName("Ursa Minor")
                    .setCaptainName("John Quincy Adams")
                    .setType(petrolier)
                    .setPort("Vieux-Port")
                    .build();
            new ContainerShipBuilder()
                    .setId(2)
                    .setName("Sirus")
                    .setCaptainName("Harold Burr")
                    .setType(petrolier)
                    .setPort("Port de Hong Kong")
                    .build();
        }
    }

    public void goToShipList(View view) {
        Intent listIntent = new Intent(this, ShipListActivity.class);
        startActivity(listIntent);
    }
}
