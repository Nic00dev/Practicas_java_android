package com.example.ejerciciofacturacion;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Clientes2 extends AppCompatActivity {

    private EditText c1,c2,c3,c4;

    private AdminSQLiteOpenHelper admin;
    private TableLayout tabla;
    private String datos[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clientes2);
        c1 = findViewById(R.id.Campo1);
        c2 = findViewById(R.id.Campo2);
        c3 = findViewById(R.id.Campo3);
        c4 = findViewById(R.id.Campo4);
        tabla = findViewById(R.id.tbc);

    }

    public void consulta(){
        int ID;
        String Nombre;
        String Apellido;
        int DNI;
        String Domicilio;

        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery() //seguimos desde aca



    }

    public void pestania_inventarios(View v){
        Intent intento = new Intent(this, MainActivity.class);
        startActivity(intento);
        finish();


    }

    public void Pestania_proveedores(View v){
        Intent intento = new Intent(this,Proveedores2.class);
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