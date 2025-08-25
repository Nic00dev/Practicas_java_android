package com.example.prototipo;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Items> lista_pokemon;

    private Adaptador_lista adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        this.setTitle("Pokedex");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red)));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lista_pokemon = new ArrayList<>();
        cargarPokemons();
        adapter = new Adaptador_lista(lista_pokemon);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int nro = item.getItemId();
        if (nro == R.id.Ordenar_nombre){
            Collections.sort(lista_pokemon, new Comparator<Items>() {
                @Override
                public int compare(Items a, Items b) {
                    return a.getNombre().compareToIgnoreCase(b.getNombre());
                }
            });
            adapter.notifyDataSetChanged(); // refresca el RecyclerView
        }
        else if (nro == R.id.Ordenar_id){
            Collections.sort(lista_pokemon, new Comparator<Items>() {
                @Override
                public int compare(Items a, Items b) {
                    return Integer.parseInt(a.getId()) - Integer.parseInt(b.getId());
                }
            });
            adapter.notifyDataSetChanged(); // refresca el RecyclerView
        }
        return true;
    }

    public void cargarPokemons() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pokeapi.co/api/v2/pokemon?limit=153"; // primeros 21

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray results = response.getJSONArray("results");
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject pokemonJson = results.getJSONObject(i);
                                String name = pokemonJson.getString("name");
                                String detailUrl = pokemonJson.getString("url"); // URL del detalle del Pokémon
                                // Ahora hacemos otro request para sacar la imagen
                                JsonObjectRequest detailRequest = new JsonObjectRequest(
                                        Request.Method.GET, detailUrl, null,
                                        new Response.Listener<JSONObject>() {
                                            @Override
                                            public void onResponse(JSONObject detailResponse) {
                                                try {
                                                    String imageUrl = detailResponse
                                                            .getJSONObject("sprites")
                                                            .getJSONObject("other")
                                                            .getJSONObject("official-artwork")
                                                            .getString("front_default");
                                                            String id = detailResponse.getString("id");

                                                    lista_pokemon.add(new Items(name, imageUrl,id));
                                                    adapter.notifyDataSetChanged();
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        },
                                        new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                error.printStackTrace();
                                            }
                                        });

                                queue.add(detailRequest);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        queue.add(request);
    }



}