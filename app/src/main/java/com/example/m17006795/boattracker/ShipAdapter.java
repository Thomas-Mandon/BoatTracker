package com.example.m17006795.boattracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ShipAdapter extends ArrayAdapter<ContainerShip> {
    public ShipAdapter(Context context, ArrayList<ContainerShip> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ContainerShip ship = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ship_list_item, parent, false);
        }

        // Lookup view for data population
        TextView shipName = (TextView) convertView.findViewById(R.id.containerID);
        TextView captainName = (TextView) convertView.findViewById(R.id.captainName);

        // Populate the data into the template view using the data object
        shipName.setText(ship.getName());
        captainName.setText(new StringBuilder("Capitaine : ").append(ship.getCaptainName()));

        return convertView;
    }
}
