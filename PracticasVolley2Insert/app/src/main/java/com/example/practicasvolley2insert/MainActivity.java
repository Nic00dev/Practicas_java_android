package com.example.practicasvolley2insert;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText tx1;
    private EditText tx2;

    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.Nom);
        tx2 = findViewById(R.id.Apell);
        // Crear una nueva cola de peticiones
        rq = Volley.newRequestQueue(this);

    }

    public void enviar(View v) {
        String nombre = tx1.getText().toString();
        String apellido = tx2.getText().toString();

        // URL del script PHP que procesa el insert
        String url = "http://192.168.100.4/insertar.php";
        // 192.168.100.4 es localhost para el emulador Android, si pruebas en dispositivo real usa tu IP local



        // Crear la solicitud POST
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Aquí recibes la respuesta JSON del PHP
                        // Puedes parsearla o mostrarla en pantalla
                        Toast.makeText(getApplicationContext(), "Respuesta: " + response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Aquí manejas los errores (ej. problemas de red, servidor caído, etc)
                        Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Aquí agregas los parámetros POST que enviará la petición
                Map<String, String> params = new HashMap<>();

                params.put("nombre", nombre);
                params.put("apellido", apellido);
                return params;
            }
        };

        // Agregar la petición a la cola para que se ejecute
        rq.add(stringRequest);
    }
}
