package com.anisapp.locationdevoiture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText name,email,password,c_password;
    private Button btn_regist;
    private ProgressBar loading;
    private static String URL_REGIST="https://locationwordpress.000webhostapp.com/sitePHP/appli/register.php";
private Button conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Inscription");
        loading=findViewById(R.id.loading);
        name =findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        c_password=findViewById(R.id.c_password);
        btn_regist=findViewById(R.id.btn_regist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Regist();
            }
        });
    }
    private void Regist()
    {
        loading.setVisibility(View.VISIBLE);
        btn_regist.setVisibility(View.GONE);

        final String name= this.name.getText().toString().trim();
        final String email= this.email.getText().toString().trim();
        final String password= this.password.getText().toString().trim();
        final String c_password= this.c_password.getText().toString().trim();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
try{
    JSONObject jsonObject=new JSONObject (response);
    String success=jsonObject.getString("success");
   // Toast.makeText(MainActivity.this, "arriver à success !", Toast.LENGTH_SHORT).show();
    if(success.equals("1") && name!=null && email!=null && password!=null && c_password!=null)
    {
        Toast.makeText(MainActivity.this, "Bravo ^^!", Toast.LENGTH_SHORT).show();
        Intent otherActivity= new Intent(getApplicationContext(),Connexion.class);
        startActivity(otherActivity);
        finish();
    }
   /* if(success.equals("2"))
    {
        Toast.makeText(MainActivity.this, "Erreur dans le code php ou baz !", Toast.LENGTH_SHORT).show();
    }*/
}catch (JSONException e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Erreur exeption!!"+e.toString(), Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    btn_regist.setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Erreur reponse!!"+error.toString(), Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                btn_regist.setVisibility(View.VISIBLE);

            }
        })
        {
            @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("email",email);
        params.put("password",password);
        return params;
    }
};
        RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
                }
}
