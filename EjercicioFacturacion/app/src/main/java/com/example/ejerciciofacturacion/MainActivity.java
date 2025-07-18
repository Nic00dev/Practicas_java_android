package com.example.ejerciciofacturacion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TableLayout tabla;
    private TableRow row;
    private TextView id;
    private TextView nombre;
    private TextView precio;
    private TextView cantidad;
    private TextView descuento;
    private TextView total;
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

        ide1 = findViewById(R.id.id1);
        nom1 = findViewById(R.id.nombre1);
        pre1 = findViewById(R.id.precio1);
        cant1 = findViewById(R.id.cantidad1);
        des1 = findViewById(R.id.descuento1);
        tabla = findViewById(R.id.tb);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void presion(View v){
        row = new TableRow(this);
        String variable = String.valueOf(contador);

        id = new TextView(this);
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
        total.setText("9999");
        total.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        row.addView(id);
        row.addView(nombre);
        row.addView(precio);
        row.addView(cantidad);
        row.addView(descuento);
        row.addView(total);

        datos = new String[]{id.getText().toString(), nombre.getText().toString(), precio.getText().toString(), cantidad.getText().toString(), descuento.getText().toString(), total.getText().toString()};

        row.setTag(datos);
        tabla.addView(row);

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
    }


}