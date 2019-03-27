package com.anisapp.locationdevoiture;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Parametres extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        getSupportActionBar().setTitle("Paramètres");
        drawerlayout=findViewById(R.id.drawerlayout);
        mToggle=new ActionBarDrawerToggle(this, drawerlayout,R.string.open,R.string.close);
        NavigationView navigationView=findViewById(R.id.design_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerlayout.addDrawerListener(mToggle);

        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profil:
                Intent otherActivity= new Intent(getApplicationContext(),Profil.class);
                startActivity(otherActivity);
                finish();
                break;
            case R.id.mesLocation:
                Intent location= new Intent(getApplicationContext(),MesLocations.class);
                startActivity(location);
                finish();
                break;
            case R.id.annonces:
                Intent ann= new Intent(getApplicationContext(),MenuPrincipal.class);
                startActivity(ann);
                finish();
                break;
            case R.id.mesVoitures:
                Intent mesvoitures= new Intent(getApplicationContext(),MesVoitures.class);
                startActivity(mesvoitures);
                finish();                    break;
            case R.id.parametres:
                Intent parametres= new Intent(getApplicationContext(),Parametres.class);
                startActivity(parametres);
                finish();                    break;
            case R.id.deconnexion:
                Intent dec= new Intent(getApplicationContext(),Connexion.class);
                startActivity(dec);
                Toast.makeText(this,"Vous etes déconnecté ^^",Toast.LENGTH_LONG).show();
                finish();                    break;

        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
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
