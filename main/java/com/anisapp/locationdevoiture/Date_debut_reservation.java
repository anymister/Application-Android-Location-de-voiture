package com.anisapp.locationdevoiture;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
public class Date_debut_reservation extends AppCompatActivity {
private Button debut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_debut_reservation);
        getSupportActionBar().setTitle("Durée de location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        final CalendarView cvf=(CalendarView)findViewById(R.id.db);
        cvf.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                                        @Override
                                        public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                                            String date=i2+"/"+i1+"/"+i;
                                            Intent intent1=new Intent(Date_debut_reservation.this,Date_fin_reservation.class);

                                            intent1.putExtra("db",date);
                                            startActivity(intent1);
                                            overridePendingTransition(R.anim.r, R.anim.lf);
                                        }
                                    }
        );

    }
}
