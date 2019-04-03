package com.example.m17006795.boattracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ModifShip extends AppCompatActivity {

    private ContainerShip bateauTemp;
    private ContainerShip bateau;
    private Spinner portSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_ship);

        //On Cherche le bateau passé en paramètre dans la liste afin de récupérer le vrai bateau dans la liste.
        bateauTemp = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        bateau = bateauTemp.searchShipId(bateauTemp);
        createActivity();
    }

    public void createActivity () {
        ((EditText) findViewById(R.id.editTextName)).setText(new StringBuilder().append(bateau.getName()));
        ((EditText) findViewById(R.id.editTextCapitaine)).setText(new StringBuilder().append(bateau.getCaptainName()));
        ((EditText) findViewById(R.id.editTextLat)).setText(new StringBuilder().append(bateau.getLatitude()));
        ((EditText) findViewById(R.id.editTextLong)).setText(new StringBuilder().append(bateau.getLongitude()));
        portSpinner = findViewById(R.id.portSpinner);
        portSpinnerConfiguration();
    }

    public void valider (View view) { //Enregistrement des valeurs dans le bateau.
        bateau.setName(((EditText) findViewById(R.id.editTextName)).getText().toString());
        bateau.setCaptainName(((EditText) findViewById(R.id.editTextCapitaine)).getText().toString());

        String latitude = (((EditText) findViewById(R.id.editTextLat)).getText().toString());
        bateau.setLatitude(Float.parseFloat(latitude));
        String longitude = (((EditText) findViewById(R.id.editTextLong)).getText().toString());
        bateau.setLongitude(Float.parseFloat(longitude));

        bateau.setPort(ListPort.searchPortByName(portSpinner.getSelectedItem().toString()));

        bateau.maj();
        finish();
    }

    public void cancel (View view) {
        Intent intent = new Intent(ModifShip.this, DetailsShipActivity.class);
        intent.putExtra("Bateau",bateau);
        startActivity(intent);
    }

    public void portSpinnerConfiguration() {
        int defaultPosition = 0;
        int cpt = 0;
        List<String> listPortSpinner = new ArrayList<>();
        for (Port p : ListPort.getListPort()) {
            listPortSpinner.add(p.getName());

            if (p.getName() == bateau.getPort().getName())
                defaultPosition = cpt;
            else
                cpt += 1;

        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listPortSpinner);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        portSpinner.setAdapter(dataAdapter);
        portSpinner.setSelection(defaultPosition);
    }


}
