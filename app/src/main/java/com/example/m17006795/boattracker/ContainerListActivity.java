package com.example.m17006795.boattracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class ContainerListActivity extends AppCompatActivity{
    private ContainerShip bateau;
    private ContainerShip bateauTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailship);
        bateauTemp = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        bateau = bateauTemp.searchShip(bateauTemp);
    }

    public void containerSpinnerConfiguration() {
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
}
