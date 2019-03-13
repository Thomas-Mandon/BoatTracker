package com.example.m17006795.boattracker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShipLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ContainerShip bateau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        bateau = (ContainerShip) getIntent().getSerializableExtra("Bateau");

        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Marqueur bateau
        LatLng posBateau = new LatLng(bateau.getLatitude(), bateau.getLongitude());
        mMap.addMarker(new MarkerOptions().position(posBateau).title(bateau.getName()));

        //Marqueur port d'origine
        LatLng posPort = new LatLng(bateau.getPort().getLatitude(), bateau.getPort().getLongitude());
        mMap.addMarker(new MarkerOptions().position(posPort).title("Port d'origine : " + bateau.getPort().getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(posBateau));
    }
}