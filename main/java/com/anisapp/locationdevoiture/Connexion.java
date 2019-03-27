package com.anisapp.locationdevoiture;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Connexion extends AppCompatActivity {
    private EditText mail, pass;
private Button btn_login;
private TextView Link_regist;
private static String URL_REGIST="";
private Button inscription;
private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion2);
        getSupportActionBar().setTitle("Location de voiture");
        //loading =findViewById(R.id.loading);
        mail=findViewById(R.id.mail);
        pass =findViewById(R.id.pass);

        btn_login=findViewById(R.id.btn_login);
        inscription=findViewById(R.id.inscription);
        load=findViewById(R.id.load);
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity= new Intent(getApplicationContext(),MainActivity.class);

                startActivity(otherActivity);
                finish();
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
       // link_regist=findViewById(R.id.link_regist);

        //btn_login.setOnClickListener(new View.OnClickListener())
    }

    public void login() {
        load.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);
        final String mail= this.mail.getText().toString().trim();
        final String pass= this.pass.getText().toString().trim();

        StringRequest request=new StringRequest(Request.Method.POST, "https://locationwordpress.000webhostapp.com/sitePHP/appli/login.php",

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                      if(response.contains("1") && mail!=null && pass!=null) {
                          Toast.makeText(getApplicationContext(),

                                  "Vous ètes connecté ^^" ,Toast.LENGTH_SHORT).show();
                          Intent otherActivity= new Intent(getApplicationContext(),MenuPrincipal.class);

                          startActivity(otherActivity);

                          finish();
                      }
                     else {
                          load.setVisibility(View.GONE);
                          Toast.makeText(getApplicationContext(),

                                  "Email ou mot de passe INCORRECTE !" ,Toast.LENGTH_SHORT).show();
                      }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // load.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),

                        "Une erreur est survenu, veuillez reessayez plus tard !" ,Toast.LENGTH_SHORT).show();

            }
        })
        {
            protected Map<String,String> params=new HashMap<>();

            @Override
            public Map<String, String> getParams() {
                params.put("e" +
                        "" +
                        "mail",mail);
                params.put("password",pass);

                return  params;
            }
        };

        Volley.newRequestQueue(this).add(request);
    }
}
