package com.anisapp.locationdevoiture;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Date;

public class Date_fin_reservation extends AppCompatActivity {
private Button fin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_fin_reservation);
        getSupportActionBar().setTitle("Durée de location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final CalendarView cvf=(CalendarView)findViewById(R.id.df);



                //Intent a= new Intent(getApplicationContext(),Confirmation.class);

                cvf.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                                                @Override
                                                public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                                                    String date=i2+"/"+i1+"/"+i;
                                                    Intent intent1=new Intent(Date_fin_reservation.this,Confirmation.class);
                                                    String db=getIntent().getStringExtra("db");

/*String tab[] = new String[0];
tab[1]=db;
tab[2]=date;
intent1.putExtra("date",tab);*/
                                                    intent1.putExtra("df",date);
                                                    intent1.putExtra("db",db);
                                                    startActivity(intent1);
                                                    overridePendingTransition(R.anim.r, R.anim.lf);
                                                }
                                            }
                );
    }
}









