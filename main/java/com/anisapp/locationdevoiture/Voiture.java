package com.anisapp.locationdevoiture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Voiture extends AppCompatActivity {
private Button reserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voiture);

        getSupportActionBar().setTitle("Détails annonce");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reserver=findViewById(R.id.button3);

        reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(getApplicationContext(),Date_debut_reservation.class);

                startActivity(a);
                finish();
            }
        });


    }
}
