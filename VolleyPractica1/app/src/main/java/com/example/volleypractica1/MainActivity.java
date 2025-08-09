package com.example.volleypractica1;

import static android.widget.Toast.LENGTH_LONG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//esto hace un select y lo muestra en la app
public class MainActivity extends AppCompatActivity {

   private TextView tv;
   private RequestQueue rq;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv1);
        rq = Volley.newRequestQueue(this); //con esto inicias el intermediario http
    }

    public void recuperar(View v){
        tv.setText(".");
        String url = "http://192.168.100.4/select1.php"; //importantee uee la url sea completa y tenga al final .php y sea del servidor
        //configurame las ordenes de lo que queres,metodo get o post,dame la url del sv,hace algo si anda bien y hace algo si falla
        JsonArrayRequest requerimiento = new JsonArrayRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0;i<response.length();i++){ //con esto recorro el json
                            try {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                tv.append("nombre"+objeto.getString("nombre"));
                                tv.append("apellido"+objeto.getString("apellido"));

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show(); //importante hacer que muestre el error si falla
                    }
                });
        rq.add(requerimiento);//actualizate


    }
}