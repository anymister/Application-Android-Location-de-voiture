package com.anisapp.locationdevoiture;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MenuPrincipal extends AppCompatActivity {
private DrawerLayout drawerlayout;
private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        drawerlayout=(DrawerLayout) findViewById(R.id.drawerlayout);
        mToggle=new ActionBarDrawerToggle(this, drawerlayout,R.string.open,R.string.close);

        drawerlayout.addDrawerListener(mToggle);

        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))

        {
return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
