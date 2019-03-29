package com.example.m17006795.boattracker;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        ListView listView = findViewById(R.id.shipList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent details = new Intent(ShipListActivity.this, DetailsShipActivity.class);
                details.putExtra("Bateau", shipAdapter.getItem(position));
                startActivityForResult(details, 0);
            }
        });

        listView.setAdapter(shipAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        recreate();
    }
}
