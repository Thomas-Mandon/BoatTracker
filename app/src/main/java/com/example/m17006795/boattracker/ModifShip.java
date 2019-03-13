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

    private ContainerShip bateau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_ship);

        bateau = (ContainerShip) getIntent().getSerializableExtra("Bateau");
        System.out.println(bateau.getName());
        createActivity();
    }

    public void createActivity () {
        ((EditText) findViewById(R.id.editTextName)).setText(new StringBuilder().append(bateau.getName()));
    }


}
