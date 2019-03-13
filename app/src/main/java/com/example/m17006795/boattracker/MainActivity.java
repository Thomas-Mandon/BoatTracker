package com.example.m17006795.boattracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContainerShipType petrolier = new ContainerShipType(1, "petrolier", 140, 150, 200);

        new ContainerShipBuilder().setName("La Voix")
                .setCaptainName("John Adams")
                .setType(petrolier)
                .setLatitude(3.66f)
                .setLongitude(3.66f)
                .setPort(new Port(0, "Pearl Harbor", 14.2f, 12.6f))
                .build();
        new ContainerShipBuilder()
                .setName("Ursa Minor")
                .setCaptainName("John Quincy Adams")
                .setType(petrolier)
                .build();
        new ContainerShipBuilder()
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
