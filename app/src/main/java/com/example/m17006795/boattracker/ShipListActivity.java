package com.example.m17006795.boattracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
                /*Toast toast = Toast.makeText(ShipListActivity.this, ((TextView) view.findViewById(R.id.shipName)).getText(), Toast.LENGTH_SHORT);
                toast.show();*/
                Intent details = new Intent(ShipListActivity.this, DetailsShipActivity.class);
                details.putExtra("Bateau", shipAdapter.getItem(position));
                startActivity(details);
            }
        });

        listView.setAdapter(shipAdapter);
    }
}
