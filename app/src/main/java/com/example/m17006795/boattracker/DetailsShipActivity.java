package com.example.m17006795.boattracker;

import android.location.Location;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DetailsShipActivity extends AppCompatActivity {

    private ContainerShip bateau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailship);
        bateau = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        creationDetails();
    }

    public void creationDetails () {

        ((TextView) findViewById(R.id.shipName)).setText(new StringBuilder("Nom : ").append(bateau.getName()));
        ((TextView) findViewById(R.id.shipType)).setText(new StringBuilder("Type : ").append(bateau.getType().getName()));
        ((TextView) findViewById(R.id.shipCapitaine)).setText(new StringBuilder("Capitaine : ").append(bateau.getCaptainName()));
        ((TextView) findViewById(R.id.shipPosition)).setText(new StringBuilder("Position: latitude ").append(bateau.getLatitude()).append(" et longitude ").append(bateau.getLongitude()));

    }

    public void getDistance(View view) {

        Button button = findViewById(R.id.calculDistance);

        Double distance = distance(bateau.getLatitude(), bateau.getPort().getLatitude(), bateau.getLongitude(), bateau.getPort().getLongitude());
        Toast toast = Toast.makeText(DetailsShipActivity.this, String.format(Locale.getDefault(), "%.2f", distance) + " km", Toast.LENGTH_SHORT);
                toast.show();
    }

    public static double distance(double lat1, double lat2, double lon1, double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // kilometers
    }

    public void goToModifShip(View view) {
        Intent intent = new Intent(this, ModifShip.class);
        intent.putExtra("Bateau",bateau);
        startActivity(intent);
    }
}
