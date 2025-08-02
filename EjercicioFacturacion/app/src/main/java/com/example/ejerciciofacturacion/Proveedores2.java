package com.example.ejerciciofacturacion;

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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Proveedores2 extends AppCompatActivity {


    private AdminSQLiteOpenHelper admin;
    private EditText c1,c2,c3,c4;
    private TableLayout tabla;
    private String [] datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_proveedores2);
        admin = new AdminSQLiteOpenHelper(this,"bd1",null,1);
        c1 = findViewById(R.id.Campo1);
        c2 = findViewById(R.id.Campo2);
        c3 = findViewById(R.id.Campo3);
        c4 = findViewById(R.id.Campo4);
        tabla = findViewById(R.id.tb);
        consulta();

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
    public void Pestania_facturacion(View v){
        Intent intento = new Intent(this,Facturar.class);
        startActivity(intento);


    }
    public void cerrar_sesion(View v){
       finish();


    }

    public void consulta(){ //para probar
        int ID;
        String Nombre;
        String CUIT;
        String Domicilio;
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from proveedores where CUIT != '9999'",null);//buscar consulta;
        tabla.removeAllViews();
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                TableRow row = new TableRow(this);

                for (int i= 0; i<cursor.getColumnCount();i++){
                    TextView tv = new TextView(this);
                    Object valor = cursor.getString(i);
                    tv.setText(valor.toString());
                    tv.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));
                    row.addView(tv);
                }
                ID = cursor.getInt(0);
                Nombre = cursor.getString(1);
                CUIT = cursor.getString(2);
                Domicilio = cursor.getString(3);
                datos = new String[]{String.valueOf(ID),Nombre,CUIT,Domicilio};
                row.setTag(datos);
                tabla.addView(row);

                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String datitos[] = (String [])v.getTag();
                        c1.setText(datitos[0]);
                        c2.setText(datitos[1]);
                        c3.setText(datitos[2]);
                        c4.setText(datitos[3]);
                    }
                });

                cursor.moveToNext();
            }


        }
        cursor.close();
        db.close();


    }

    public void agregar(View v){
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        //registro.put("ID_Proveedor",c1.getText().toString());
        registro.put("Nombre",c2.getText().toString());
        registro.put("CUIT",c3.getText().toString());
        registro.put("Domicilio",c4.getText().toString());
        db.insert("proveedores",null,registro);
        db.close();
        consulta();
    }
    public void borrado (View v){ //revisar
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("Nombre",c2.getText().toString());
        registro.put("CUIT",9999);
        registro.put("Domicilio",c4.getText().toString());
        String [] args = {String.valueOf(c1.getText())};
        db.update("proveedores",registro ,"ID_Proveedor = ?",args);
        db.close();
        consulta();
    }
    public void modificar (View v){ //revisar
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("Nombre",c2.getText().toString());
        registro.put("CUIT",c3.getText().toString());
        registro.put("Domicilio",c4.getText().toString());
        String [] args = {String.valueOf(c1.getText())};
        db.update("proveedores",registro ,"ID_Proveedor = ?",args);
        db.close();
        consulta();
    }

    public void busqueda (View v){ //PROBAR
        int ID;
        String Nombre;
        String CUIT;
        String Domicilio;
        SQLiteDatabase db = admin.getReadableDatabase();
        String [] args = {c3.getText().toString()};
        Cursor cursor = db.rawQuery("select * from proveedores where (CUIT != 9999 AND CUIT = ?)",args);//buscar consulta;
        tabla.removeAllViews();

        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                TableRow row = new TableRow(this);

                for (int i= 0; i<cursor.getColumnCount();i++){
                    TextView tv = new TextView(this);
                    Object valor = cursor.getString(i);
                    tv.setText(valor.toString());
                    tv.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));
                    row.addView(tv);
                }
                ID = cursor.getInt(0);
                Nombre = cursor.getString(1);
                CUIT = cursor.getString(2);
                Domicilio = cursor.getString(3);
                datos = new String[]{String.valueOf(ID),Nombre,CUIT,Domicilio};
                row.setTag(datos);
                tabla.addView(row);

                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String datitos[] = (String [])v.getTag();
                        c1.setText(datitos[0]);
                        c2.setText(datitos[1]);
                        c3.setText(datitos[2]);
                        c4.setText(datitos[3]);
                    }
                });
                cursor.moveToNext();
            }


        }
        cursor.close();
        db.close();






    }
}