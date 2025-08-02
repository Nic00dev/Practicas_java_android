package com.example.ejerciciofacturacion;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import org.w3c.dom.Text;

public class Facturar extends AppCompatActivity {
    private AdminSQLiteOpenHelper admin;
    private EditText c1,c2,c3,c4,c5,c6;
    private Button Resultado_total;
    private TableLayout tabla;
    private String[] datos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_facturar);
        admin = new AdminSQLiteOpenHelper(this,"bd1",null,1);
        c1 = findViewById(R.id.Campo1);
        c2 = findViewById(R.id.Campo2);
        c3 = findViewById(R.id.Campo3);
        c4 = findViewById(R.id.Campo4);
        c5 = findViewById(R.id.Campo5);
        c6 = findViewById(R.id.Campo6);
        tabla = findViewById(R.id.tb);
        Resultado_total = findViewById(R.id.resul);
        TextWatcher sumar = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            opreracion();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        c3.addTextChangedListener(sumar);
        c4.addTextChangedListener(sumar);
        c5.addTextChangedListener(sumar);

    }

    public void opreracion(){
        String n1 = c3.getText().toString();
        String n2 = c4.getText().toString();
        String n3 = c5.getText().toString();

        // Convertimos los números a double para que la división sea precisa
        double num1 = n1.isEmpty() ? 0 : Double.parseDouble(n1);
        double num2 = n2.isEmpty() ? 0 : Double.parseDouble(n2);
        double num3 = n3.isEmpty() ? 0 : Double.parseDouble(n3);
        double resultado;
        double totalSinDescuento;
        double montoDescuento;

        // Hacemos la operación con el número 100.0 para que sepa que es decimal
        if (num3 >0) {
            totalSinDescuento = num1 * num2;
            montoDescuento = totalSinDescuento * (num3 / 100.0);
            resultado = totalSinDescuento - montoDescuento;
        }
        else{
            resultado = (num1 * num2);
        }

        // Convertimos el resultado de vuelta a texto
        String res = String.valueOf(resultado);
        c6.setText(res);
    }

    public void consulta (){
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("select ID,Nombre,Precio,Cantidad,Descuento,Total from ventas where Visible = 1",null);; // agregar

        int ID;
        String Nombre;
        int Precio;
        int Cantidad;
        int Descuento;
        double Total;
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
                ID = cursor.getInt(0);
                Nombre = cursor.getString(1);
                Precio = cursor.getInt(2);
                Cantidad= cursor.getInt(3);
                Descuento = cursor.getInt(4);
                Total = cursor.getDouble(5);


                datos =  new String[]{String.valueOf(ID),Nombre,String.valueOf(Precio),String.valueOf(Cantidad),String.valueOf(Descuento),String.valueOf(Total)};
                row.setTag(datos);
                tabla.addView(row);

                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String datitos[] = (String[]) v.getTag();
                        c1.setText(datitos[0]);
                        c2.setText(datitos[1]);
                        c3.setText(datitos[2]);

                        c4.setText(datitos[3]);
                        c5.setText(datitos[4]);
                        c6.setText(datitos[5]);

                    }
                });
                cursor.moveToNext();
            }


        }
        cursor.close();
        db.close();
    }

    public void agregar (View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("Nombre",c2.getText().toString());
        registro.put("Precio",Integer.parseInt(c3.getText().toString()));
        registro.put("Cantidad",Integer.parseInt(c4.getText().toString()));
        registro.put("Descuento",Integer.parseInt(c5.getText().toString()));
        registro.put("Total",Double.parseDouble(c6.getText().toString()));
        registro.put ("Visible",1);
        bd.insert("ventas",null,registro);
        Toast.makeText(this,"datos enviados",Toast.LENGTH_SHORT).show();
        bd.close(); //recordar comentar esto para el inspector
        consulta();

    }

    public void modificar (View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        //int desc = des1.getText().toString();
        registro.put("Nombre",c2.getText().toString());
        registro.put("Precio",Integer.parseInt(c3.getText().toString()));
        registro.put("Cantidad",Integer.parseInt(c4.getText().toString()));
        registro.put("Descuento",Integer.parseInt(c5.getText().toString()));
        registro.put("Total",Double.parseDouble(c6.getText().toString()));
        registro.put ("Visible",1);
        String[] args = { String.valueOf(c1.getText()) };
        int filas = bd.update("ventas",registro,"ID = ?",args);
        bd.close();
        consulta();

    }



    public void borrar (View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        //int desc = des1.getText().toString();
        registro.put("Nombre",c2.getText().toString());
        registro.put("Precio",Integer.parseInt(c3.getText().toString()));
        registro.put("Cantidad",Integer.parseInt(c4.getText().toString()));
        registro.put("Descuento",Integer.parseInt(c5.getText().toString()));
        registro.put("Total",Double.parseDouble(c6.getText().toString()));
        registro.put ("Visible",0);
        String[] args = { String.valueOf(c1.getText()) };
        int filas = bd.update("ventas",registro,"ID = ?",args);
        bd.close();
        consulta();

    }
    public void borrartodo (View v){
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        //int desc = des1.getText().toString();
        registro.put("Nombre",c2.getText().toString());
        registro.put("Precio",Integer.parseInt(c3.getText().toString()));
        registro.put("Cantidad",Integer.parseInt(c4.getText().toString()));
        registro.put("Descuento",Integer.parseInt(c5.getText().toString()));
        registro.put("Total",Double.parseDouble(c6.getText().toString()));
        registro.put ("Visible",0);
        int filas = bd.update("ventas",registro,"Cantidad >= 0",null);
        bd.close();
        consulta();

    }

    public void cobro (View v){
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(Total) FROM ventas WHERE Visible = 1", null);

        if (cursor.moveToFirst()) {
            String suma = cursor.getString(0); // puede ser null si no hay filas
            Resultado_total.setText(suma != null ? suma : "0");
        } else {
            Resultado_total.setText("0");
        }

        cursor.close();
        db.close();
    }


}


