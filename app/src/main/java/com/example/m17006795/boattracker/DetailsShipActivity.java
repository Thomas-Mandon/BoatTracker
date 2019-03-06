package com.example.m17006795.boattracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class DetailsShipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbateau);

        creationDetails();
    }

    public void creationDetails () {
        ContainerShip bateau = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        ((TextView) findViewById(R.id.shipName)).setText(new StringBuilder("Nom : ").append(bateau.getName()));
        ((TextView) findViewById(R.id.shipType)).setText(new StringBuilder("Type : ").append(bateau.getType().getName()));
    }

}
