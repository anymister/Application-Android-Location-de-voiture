package com.anisapp.locationdevoiture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {
private Button confimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        getSupportActionBar().setTitle("Récapitulatif");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        confimer=findViewById(R.id.confirmer);
        //TextView db=findViewById(R.id.db);
        TextView df=findViewById(R.id.df);
        TextView db=findViewById(R.id.db);
        //db.setText(getIntent().getExtras().getString("db"));
        df.setText(getIntent().getStringExtra("df"));
        db.setText(getIntent().getStringExtra("db"));
        confimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a= new Intent(getApplicationContext(),Bravo.class);

                startActivity(a);
                overridePendingTransition(R.anim.r, R.anim.lf);
            }
        });

    }
}
