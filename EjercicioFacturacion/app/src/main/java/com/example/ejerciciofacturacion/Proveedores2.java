package com.example.ejerciciofacturacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Proveedores2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_proveedores2);

    }

    public void pestania_inventarios(View v){
        Intent intento = new Intent(this, MainActivity.class);
        startActivity(intento);
        finish();


    }

    public void Pestania_clientes(View v){
        Intent intento = new Intent(this,Clientes2.class);
        startActivity(intento);
        finish();


    }
    //    public void Pestania_facturacion(View v){
//        Intent intento = new Intent(this,Clientes2.class);
//        startActivity(intento);
//
//
//    }
    public void cerrar_sesion(View v){
       finish();


    }
}