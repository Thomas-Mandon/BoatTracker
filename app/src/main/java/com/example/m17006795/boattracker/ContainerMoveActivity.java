package com.example.m17006795.boattracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class ContainerMoveActivity extends AppCompatActivity {
    private ContainerShip bateau;
    private ContainerShip bateauTemp;
    private ContainerShip bateauCible;

    private Container containerCible;

    private Spinner containerSpinner;
    private Spinner bateauxSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_move);

        //On Cherche le bateau passé en paramètre dans la liste afin de récupérer le vrai bateau dans la liste.
        bateauTemp = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        bateau = bateauTemp.searchShipId(bateauTemp);
        createActivity();
    }

    public void createActivity() {
        containerSpinner = findViewById(R.id.containerSpinner);
        containerSpinnerConfiguration();
        bateauxSpinner = findViewById(R.id.bateauxSpinner);
        bateauxSpinnerConfiguration();
    }

    public void containerSpinnerConfiguration() {
        List<String> listContainerSpinner = new ArrayList<>();
        for (Container c : bateau.getContainers()) {
            listContainerSpinner.add(Integer.toString(c.getId()));
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listContainerSpinner);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        containerSpinner.setAdapter(dataAdapter);
    }

    public void bateauxSpinnerConfiguration() {
        List<String> listBateauxSpinner = new ArrayList<>();
        for (ContainerShip c : ContainerShip.getShips()) {
            if (ShipUnder300m(c))
                listBateauxSpinner.add(c.getName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listBateauxSpinner);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bateauxSpinner.setAdapter(dataAdapter);
    }

    public boolean ShipUnder300m (ContainerShip bateauCible) {

        System.out.println("Distance entre les bateaux " + DetailsShipActivity.distance(bateau.getLatitude(), bateau.getLongitude(), bateauCible.getLatitude(), bateauCible.getLongitude()));
        System.out.println("Bateau 1 : " + bateau.getLatitude() + " " + bateau.getLongitude());
        System.out.println("Bateau 2 : " + bateauCible.getLatitude() + " " + bateauCible.getLongitude());
        if (DetailsShipActivity.distance(bateau.getLatitude(), bateau.getLongitude(), bateauCible.getLatitude(), bateauCible.getLongitude()) <= 0.3)
            return true;
        else
            return false;
    }

    public void valider (View view) { //Enregistrement des valeurs dans le bateau.
        int containerID = Integer.parseInt(containerSpinner.getSelectedItem().toString());
        containerCible = bateau.searchContainerId(containerID); //On récuppère le container
        bateauCible = ContainerShip.searchShipName(bateauxSpinner.getSelectedItem().toString()); // on Récupppère le bateau ciblé
        bateauCible.addContainer(containerCible);
        bateau.removeContainer(containerCible);
        finish();
    }
}
