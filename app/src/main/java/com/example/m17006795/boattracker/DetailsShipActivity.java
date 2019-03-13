package com.example.m17006795.boattracker;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsShipActivity extends AppCompatActivity {

    private ContainerShip bateau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailship);
        bateau = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        creationDetails();
        getDistance();
    }

    public void creationDetails () {

        ((TextView) findViewById(R.id.shipName)).setText(new StringBuilder("Nom : ").append(bateau.getName()));
        ((TextView) findViewById(R.id.shipType)).setText(new StringBuilder("Type : ").append(bateau.getType().getName()));
    }

    public void getDistance() {

        Button button = findViewById(R.id.calculDistance);

        /*Toast toast = Toast.makeText(DetailsShipActivity.this, , Toast.LENGTH_SHORT);
                toast.show();*/
    }

}
