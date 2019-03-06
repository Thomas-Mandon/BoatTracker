package com.example.m17006795.boattracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ShipListActivity extends AppCompatActivity {
    private ShipAdapter shipAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_list);

        fillShipList();
    }

    private void fillShipList() {
        shipAdapter = new ShipAdapter(this, ContainerShip.getShips());
        ListView listView = (ListView) findViewById(R.id.shipList);
        listView.setAdapter(shipAdapter);
    }
}
