package com.example.m17006795.boattracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static GoogleSignInAccount account;
    private GoogleSignInClient signInClient;

    String TAG = "MainActivityDB";

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    Database database = new Database();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firestore.collection("ports")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document2 : task.getResult()) {

                                Log.d(TAG, "Port : " + document2.getData());
                                Log.d(TAG, Integer.toString(ListPort.getListPort().size()));
                                new PortBuilder()
                                        .setId(((Number)document2.get("id")).intValue())
                                        .setName((String)document2.get("name"))
                                        .setLongitude(((Number) document2.get("longitude")).floatValue())
                                        .setLatitude(((Number) document2.get("latitude")).floatValue())
                                        .build();
                                Log.d(TAG, Integer.toString(ListPort.getListPort().size()));
                            }
                        }
                        else {
                            Log.w(TAG, "No such document", task.getException());
                        }
                    }
                });


        firestore.collection("bateaux")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        try {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    ContainerShip bateau = new ContainerShipBuilder()
                                            .setId(((Number)document.get("id")).intValue())
                                            .setCaptainName((String) document.get("captainName"))
                                            .setName((String) document.get("name"))
                                            .setLatitude(((Number) document.get("latitude")).floatValue())
                                            .setLongitude(((Number) document.get("longitude")).floatValue())
                                            .setPort(ListPort.searchPortByName((String)document.get("nomPort")))
                                            .build();
                                    Log.d (TAG, ListPort.searchPortByName((String)document.get("nomPort")) == null ? "Null" : ListPort.searchPortByName((String)document.get("nomPort")).getName());
                                }
                            } else {
                                Log.w(TAG, "No such document", task.getException());
                            }
                        }
                        catch (NullPointerException n) {
                            n.getMessage();
                        }
                    }
                });
        Container c1 = new Container(0,5,5,5);
        Container c2 = new Container(1,6,6,6);
        Container c3 = new Container(2,68,68,68);

        /*Port pearlHarbor = new PortBuilder()
                            .setId(0)
                            .setName("Pearl Harbor")
                            .setLatitude(21.339884)
                            .setLongitude(-157.970901)
                            .build();
        //database.addPort(firestore, pearlHarbor);

        Port vieuxPort = new PortBuilder()
                            .setId(0)
                            .setName("Vieux-Port")
                            .setLatitude(43.295175)
                            .setLongitude(5.372672)
                            .build();
        //database.addPort(firestore, vieuxPort);

        Port leHavre = new PortBuilder()
                            .setId(0)
                            .setName("Le Havre")
                            .setLatitude(49.4938)
                            .setLongitude(0.1077)
                            .build();
        //database.addPort(firestore, leHavre);

        Port hongKong = new PortBuilder()
                            .setId(0)
                            .setName("Port de Hong Kong")
                            .setLatitude(22.333332)
                            .setLongitude(114.1166662)
                            .build();
        //database.addPort(firestore, hongKong);
        */

        ContainerShipType petrolier = new ContainerShipType(1, "petrolier", 140, 150, 200);

        findViewById(R.id.sign_in_button).setOnClickListener(this);
        signedInCheck();
    }

    private void signedInCheck() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        signInClient = GoogleSignIn.getClient(this, gso);
        account = GoogleSignIn.getLastSignedInAccount(this);

        updateUI(account);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ship_list_button:
                goToShipList();
                break;
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.sign_out_button:
                signOut();
        }
    }

    private void signIn() {
        Intent signInIntent = signInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1);
    }

    private void signOut() {
        signInClient.signOut();
        recreate();
    }

    private void goToShipList() {
        Intent listIntent = new Intent(this, ShipListActivity.class);
        startActivity(listIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 1) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

    public void updateUI(GoogleSignInAccount account) {
        View signInButton = findViewById(R.id.sign_in_button);
        View signOutButton = findViewById(R.id.sign_out_button);
        TextView connectedText = findViewById(R.id.connected_text);
        if (account != null) {
            signInButton.setVisibility(View.GONE);
            signOutButton.setVisibility(View.VISIBLE);
            connectedText.setVisibility(View.VISIBLE);
            connectedText.setText(getString(R.string.connected_text_content, account.getEmail()));
        }
        else {
            signInButton.setVisibility(View.VISIBLE);
            signOutButton.setVisibility(View.GONE);
            connectedText.setVisibility(View.GONE);
        }
    }
}
