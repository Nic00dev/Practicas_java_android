package com.example.ejerciciofacturacion;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Clientes2 extends AppCompatActivity {

    private EditText c0,c1,c2,c3,c4;

    private AdminSQLiteOpenHelper admin;
    private TableLayout tabla;
    private String datos[];
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clientes2);
        admin = new AdminSQLiteOpenHelper(this,"bd1",null,1);
        c0 = findViewById(R.id.campo0);
        c1 = findViewById(R.id.Campo1);
        c2 = findViewById(R.id.Campo2);
        c3 = findViewById(R.id.Campo3);
        c4 = findViewById(R.id.Campo4);
        tabla = findViewById(R.id.tbc);
        consulta();
    }

    public void consulta(){
        int ID;
        String Nombre;
        String Apellido;
        int DNI;
        String Domicilio;

        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("select ID_Cliente,Nombre,Apellido,DNI,Domicilio from clientes where DNI != 9999",null); //seguimos desde aca

        tabla.removeAllViews();
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                TableRow row = new TableRow(this);
                for (int i = 0;i<cursor.getColumnCount();i++){
                    TextView tv = new TextView(this);
                    Object valor = cursor.getString(i);
                    tv.setText(valor.toString());
                    tv.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
                    row.addView(tv);
                }

                ID = cursor.getInt(0); //esto lo hemos modificado
                Nombre = cursor.getString(1);
                Apellido = cursor.getString(2);
                DNI = cursor.getInt(3);
                Domicilio = cursor.getString(4);

                datos =  new String[]{String.valueOf(ID),Nombre,Apellido,String.valueOf(DNI),Domicilio};
                row.setTag(datos);
                tabla.addView(row);

                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String datitos[] = (String[]) v.getTag();
                        c0.setText(datitos[0]);
                        c1.setText(datitos[1]);
                        c2.setText(datitos[2]);

                        c3.setText(datitos[3]);
                        c4.setText(datitos[4]);

                    }
                });
                cursor.moveToNext();

            }

        }
        cursor.close();
        db.close();

    }

    public void busqueda (View v){
        int ID;
        String Nombre;
        String Apellido;
        int DNI;
        String Domicilio;

        SQLiteDatabase db = admin.getReadableDatabase();
        String [] args ={c3.getText().toString()};
        Cursor cursor = db.rawQuery("select ID_Cliente,Nombre,Apellido,DNI,Domicilio from clientes where (DNI != 9999 AND DNI = ?)",args);
        tabla.removeAllViews();
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                TableRow row = new TableRow(this);
                for (int i = 0;i<cursor.getColumnCount();i++){
                    TextView tv = new TextView(this);
                    Object valor = cursor.getString(i);
                    tv.setText(valor.toString());
                    tv.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));
                    row.addView(tv);
                }
                ID = cursor.getInt(0); //esto lo hemos modificado
                Nombre = cursor.getString(1);
                Apellido = cursor.getString(2);
                DNI = cursor.getInt(3);
                Domicilio = cursor.getString(4);
                datos = new String[]{String.valueOf(ID),Nombre,Apellido,String.valueOf(DNI),Domicilio};
                row.setTag(datos);
                tabla.addView(row);

                cursor.moveToNext();
            }
            cursor.close();
            db.close();

        }
        else{
            Toast.makeText(this, "sin datos",Toast.LENGTH_SHORT).show();
            consulta();
        }
    }

    public void agregar(View v){

        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("Nombre",c1.getText().toString());
        registro.put("Apellido",c2.getText().toString());

        registro.put("DNI",c3.getText().toString());
        registro.put("Domicilio",c4.getText().toString());
        db.insert("clientes",null,registro);
        db.close();
        consulta();

    }

    public void borrado(View v){
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("Nombre",c1.getText().toString());
        registro.put("Apellido",c2.getText().toString());

        registro.put("DNI",9999);
        registro.put("Domicilio",c4.getText().toString());
        String [] args = {String.valueOf(c0.getText())};
        int filas = db.update("clientes",registro,"ID_Cliente = ?",args);

        db.close();
        consulta();
    }



    public void modificar(View v) {
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("Nombre",c1.getText().toString());
        registro.put("Apellido",c2.getText().toString());

        registro.put("DNI",c3.getText().toString());
        registro.put("Domicilio",c4.getText().toString());
        String [] args = {String.valueOf(c0.getText())};
        int filas = db.update("clientes",registro,"ID_Cliente = ?",args);
        consulta();
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
        public void Pestania_facturacion(View v){
           Intent intento = new Intent(this,Facturar.class);
           startActivity(intento);


   }
    public void cerrar_sesion(View v){
        finish();

    }

}