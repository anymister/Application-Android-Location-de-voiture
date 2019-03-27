package com.anisapp.locationdevoiture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        getSupportActionBar().setTitle("Dates de réservation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
