package com.example.ejerciciofacturacion;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private AdminSQLiteOpenHelper admin;
    private Button button;
    private TableLayout tabla;

    private String datos [];

    private EditText ide1;
    private EditText nom1;
    private EditText pre1;
    private EditText cant1;
    private EditText des1;
    private int contador = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        admin = new AdminSQLiteOpenHelper(this,"bd1",null,1);
        ide1 = findViewById(R.id.id1);
        nom1 = findViewById(R.id.nombre1);
        pre1 = findViewById(R.id.precio1);
        cant1 = findViewById(R.id.cantidad1);
        des1 = findViewById(R.id.descuento1);
        tabla = findViewById(R.id.tb);
        consulta();

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void presion(View v){
        //String variable = String.valueOf(contador);

        /*id = new TextView(this);
        id.setText("001");
        id.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        nombre = new TextView(this);
        nombre.setText("Lapicera");
        nombre.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        precio = new TextView(this);
        precio.setText("200");
        precio.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        cantidad = new TextView(this);
        cantidad.setText("3");
        cantidad.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        descuento = new TextView(this);
        descuento.setText("10");
        descuento.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        total = new TextView(this);
        total.setText("9999");*/
        agregar();




        //tabla.addView(row);



    }

    public void agregar (){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("Nombre",nom1.getText().toString());
        registro.put("Precio",Integer.parseInt(pre1.getText().toString()));
        registro.put("Cantidad",Integer.parseInt(cant1.getText().toString()));
        registro.put("Descuento",Integer.parseInt(des1.getText().toString()));
        bd.insert("mercaderia",null,registro);
        Toast.makeText(this,"datos enviados",Toast.LENGTH_SHORT).show();
        bd.close(); //recordar comentar esto para el inspector
        consulta();

    }
    public void consulta(){
        String id;
        String nombre;
        int precio;
        int cantidad;
        int descuento;
        SQLiteDatabase bd = admin.getReadableDatabase();
        Cursor cursor= bd.rawQuery("select ID,Nombre,Precio,Cantidad,Descuento from mercaderia where descuento != 9999",null);
        tabla.removeAllViews(); //limpiamos tabla
        if (cursor.moveToFirst()){//si hay datos movete al primero en la db
            while(!cursor.isAfterLast()){ //mientras cursor no este en el ultimo
                TableRow row = new TableRow(this);

                for (int i = 0;i<cursor.getColumnCount();i++){
                    TextView tv = new TextView(this);
                    Object valor = cursor.getString(i);
                    tv.setText(valor.toString());
                    tv.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1));//creas un layout con contenido en codigo en lugar de xml
                    row.addView(tv);}


                id = cursor.getString(0);
                nombre= cursor.getString(1);
                precio= Integer.parseInt(cursor.getString(2)); //arreglar esot para que me de un getint
                cantidad= Integer.parseInt(cursor.getString(3));
                descuento= Integer.parseInt(cursor.getString(4));

                datos = new String[]{id, nombre, String.valueOf(precio), String.valueOf(cantidad), String.valueOf(descuento)};
                row.setTag(datos);

                tabla.addView(row); // agregar la fila a la tabla
                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String [] datitos = (String[]) v.getTag();
                        contador = contador+1;
                        ide1.setText(datitos[0]);
                        nom1.setText(datitos[1]);

                        pre1.setText(datitos[2]);
                        cant1.setText(datitos[3]);
                        des1.setText(datitos[4]);


                    }
                });
                cursor.moveToNext(); // avanzar al siguiente registr

            }


        }
        else{
            Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        bd.close();


    }
    public void borrar (View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        //int desc = des1.getText().toString();
        //registro.put("Nombre",nom1.getText().toString());
        //registro.put("Precio",Integer.parseInt(pre1.getText().toString()));
        //registro.put("Cantidad",Integer.parseInt(cant1.getText().toString()));
        registro.put("Descuento",9999);
        Toast.makeText(this, "borrado", Toast.LENGTH_SHORT).show();
        String[] args = { String.valueOf(ide1.getText()) };
        int filas = bd.update("mercaderia",registro,"ID = ?",args);
        bd.close();
        consulta();
    }

    public void modificar (View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        //int desc = des1.getText().toString();
        registro.put("Nombre",nom1.getText().toString());
        registro.put("Precio",Integer.parseInt(pre1.getText().toString()));
        registro.put("Cantidad",Integer.parseInt(cant1.getText().toString()));
        registro.put("Descuento",Integer.parseInt(des1.getText().toString()));
        Toast.makeText(this, "modificado"+ide1.getText().toString(), Toast.LENGTH_SHORT).show();
        String[] args = { String.valueOf(ide1.getText()) };
        int filas = bd.update("mercaderia",registro,"ID = ?",args);
        bd.close();
        consulta();

    }

    public void Pestania_clientes(View v){
        Intent intento = new Intent(this,Clientes2.class);
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