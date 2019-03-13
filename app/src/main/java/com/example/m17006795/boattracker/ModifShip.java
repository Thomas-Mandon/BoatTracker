package com.example.m17006795.boattracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModifShip extends AppCompatActivity {

    private ContainerShip bateauTemp;
    private ContainerShip bateau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_ship);

        bateauTemp = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        bateau = bateauTemp.searchShip(bateauTemp);
        createActivity();
    }

    public void createActivity () {
        ((EditText) findViewById(R.id.editTextName)).setText(new StringBuilder().append(bateau.getName()));
        ((EditText) findViewById(R.id.editTextCapitaine)).setText(new StringBuilder().append(bateau.getCaptainName()));
        ((EditText) findViewById(R.id.editTextPort)).setText(new StringBuilder().append(bateau.getPort()));
        ((EditText) findViewById(R.id.editTextLat)).setText(new StringBuilder().append(bateau.getLatitude()));
        ((EditText) findViewById(R.id.editTextLong)).setText(new StringBuilder().append(bateau.getLongitude()));
    }

    public void valider (View view) {
        bateau.setName(((EditText) findViewById(R.id.editTextName)).getText().toString());
        bateau.setCaptainName(((EditText) findViewById(R.id.editTextCapitaine)).getText().toString());
        //bateau.setPort(((EditText) findViewById(R.id.editTextPort)).getText().toString());

        String latitude = (((EditText) findViewById(R.id.editTextLat)).getText().toString());
        bateau.setLatitude(Float.parseFloat(latitude));
        String longitude = (((EditText) findViewById(R.id.editTextLong)).getText().toString());
        bateau.setLongitude(Float.parseFloat(longitude));

        Intent intent = new Intent(ModifShip.this, DetailsShipActivity.class);
        intent.putExtra("Bateau",bateau);
        startActivity(intent);
    }

    public void cancel (View view) {
        Intent intent = new Intent(ModifShip.this, DetailsShipActivity.class);
        intent.putExtra("Bateau",bateau);
        startActivity(intent);
    }


}
