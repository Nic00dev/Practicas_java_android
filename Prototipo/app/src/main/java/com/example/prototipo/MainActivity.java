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

import java.util.ArrayList;
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
        lista_pokemon.add(new Items("Ítem 1", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 2", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 3", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 4", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 5", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 6", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 7", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 8", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 9", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 10", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 11", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 12", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 13", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 14", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 15", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 16", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 17", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 18", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 19", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 20", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 21", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 22", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 23", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 24", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 25", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 26", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 27", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 28", R.drawable.ic_launcher_background));
        lista_pokemon.add(new Items("Ítem 29", R.drawable.ic_launcher_foreground));
        lista_pokemon.add(new Items("Ítem 30", R.drawable.ic_launcher_background));;
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
            Toast.makeText(this,"este es el nombre",Toast.LENGTH_LONG).show();
        }
        else if (nro == R.id.Ordenar_id){
            Toast.makeText(this,"este es el id",Toast.LENGTH_LONG).show();
        }
        return true;
    }


}