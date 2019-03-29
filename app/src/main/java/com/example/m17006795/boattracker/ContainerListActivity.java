package com.example.m17006795.boattracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class ContainerListActivity extends AppCompatActivity {
    private ContainerShip bateau;
    private ContainerShip bateauTemp;
    private Spinner containerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_list);

        //On Cherche le bateau passé en paramètre dans la liste afin de récupérer le vrai bateau dans la liste.
        bateauTemp = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        bateau = bateauTemp.searchShip(bateauTemp);
        createActivity();
    }

    public void createActivity() {
        containerSpinner = findViewById(R.id.containerSpinner);
        System.out.println("TEST");
        containerSpinnerConfiguration();
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
}
