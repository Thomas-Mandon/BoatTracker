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

        /*FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        firestore.setFirestoreSettings(settings);

        DocumentReference docRef = firestore.collection("/bateaux")
                .document("/zgVwodJIZIRXEEzq0ejQ");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {*/
        firestore.collection("bateaux")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            }
                        }
                        else {
                            Log.w(TAG, "No such document", task.getException());
                            }
                        }
                });

        ContainerShipType petrolier = new ContainerShipType(1, "petrolier", 140, 150, 200);

        new ContainerShipBuilder().setName("La Voix")
                .setId(0)
                .setCaptainName("John Adams")
                .setType(petrolier)
                .setLatitude(3.66f)
                .setLongitude(3.66f)
                .setPort(new Port(0, "Pearl Harbor", 14.2f, 12.6f))
                .build();
        new ContainerShipBuilder()
                .setId(1)
                .setName("Ursa Minor")
                .setCaptainName("John Quincy Adams")
                .setType(petrolier)
                .build();
        new ContainerShipBuilder()
                .setId(2)
                .setName("Sirus")
                .setCaptainName("Harold Burr")
                .setType(petrolier)
                .build();
    }

    public void goToShipList(View view) {
        Intent listIntent = new Intent(this, ShipListActivity.class);
        startActivity(listIntent);
    }
}
