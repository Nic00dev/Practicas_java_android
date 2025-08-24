package com.example.prototipo;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Descripcion_pokemon extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.descripcion_pokemon);
    this.setTitle("Pokedex");
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red)));



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_descripcion,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int nro = item.getItemId();
        if (nro == R.id.Volver){
            finish();        }
        return true;
    }

    public void regresar(View v){
        finish();

    }


}
