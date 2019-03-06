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

        new ContainerShipBuilder().setName("La Voix").setCaptainName("John Adams").build();
        new ContainerShipBuilder().setName("Ursa Minor").setCaptainName("John Quincy Adams").build();
        new ContainerShipBuilder().setName("Sirus").setCaptainName("Harold Burr").build();
    }

    public void goToShipList(View view) {
        Intent listIntent = new Intent(this, ShipListActivity.class);
        startActivity(listIntent);
    }
}
