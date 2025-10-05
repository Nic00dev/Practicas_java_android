//🧾 Ejercicio 2: Tabla de horarios demoníacos
//
//Objetivo: Crear un horario semanal con materias elegidas.
//
//🧩 Componentes:
//
//    TableLayout con días (tipo grilla).
//
//    Cada celda es un TextView con estilo.
//
//    Spinner: Elegir materia a agregar (solo nombres).
//
//    Button: “Asignar materia”.
//
//    TextView: Muestra qué materia pusiste dónde.
//
//🧪 Extra sencillo:
//Que al pulsar sobre una celda de la tabla, se resalte o cambie color, indicando selección activa.
//
//🎯 Aprendes: TableLayout, Spinner, control dinámico con clicks, interacción entre vistas.


package com.example.ejerciciosjavaparte2ej2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28,res;
    private String valor = "";
    private Spinner spinner;
    private String [] materias= {"Matematica","Fisica","Programacion"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        res = findViewById(R.id.resultado);
        spinner = findViewById(R.id.spinner4);

        ArrayAdapter <String> adaptador1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,materias);
        spinner.setAdapter(adaptador1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void colorear (View v){//puedo meter un bucle for
        a1 = findViewById(R.id.t1);
        a2 = findViewById(R.id.t2);
        a3 = findViewById(R.id.t3);
        a4 = findViewById(R.id.t4);
        a5 = findViewById(R.id.t5);
        a6 = findViewById(R.id.t6);
        a7 = findViewById(R.id.t7);
        a8 = findViewById(R.id.t8);
        a9 = findViewById(R.id.t9);
        a10 = findViewById(R.id.t10);
        a11 = findViewById(R.id.t11);
        a12 = findViewById(R.id.t12);
        a13 = findViewById(R.id.t13);
        a14 = findViewById(R.id.t14);
        a15 = findViewById(R.id.t15);
        a16 = findViewById(R.id.t16);
        a17 = findViewById(R.id.t17);
        a18 = findViewById(R.id.t18);
        a19 = findViewById(R.id.t19);
        a20 = findViewById(R.id.t20);
        a21 = findViewById(R.id.t21);
        a22 = findViewById(R.id.t22);
        a23 = findViewById(R.id.t23);
        a24 = findViewById(R.id.t24);
        a25 = findViewById(R.id.t25);
        a26 = findViewById(R.id.t26);
        a27 = findViewById(R.id.t27);
        a28 = findViewById(R.id.t28);

        a1.setBackgroundColor(Color.TRANSPARENT);
        a2.setBackgroundColor(Color.TRANSPARENT);
        a3.setBackgroundColor(Color.TRANSPARENT);
        a4.setBackgroundColor(Color.TRANSPARENT);
        a5.setBackgroundColor(Color.TRANSPARENT);
        a6.setBackgroundColor(Color.TRANSPARENT);
        a7.setBackgroundColor(Color.TRANSPARENT);
        a8.setBackgroundColor(Color.TRANSPARENT);
        a9.setBackgroundColor(Color.TRANSPARENT);
        a10.setBackgroundColor(Color.TRANSPARENT);
        a11.setBackgroundColor(Color.TRANSPARENT);
        a12.setBackgroundColor(Color.TRANSPARENT);
        a13.setBackgroundColor(Color.TRANSPARENT);
        a14.setBackgroundColor(Color.TRANSPARENT);
        a15.setBackgroundColor(Color.TRANSPARENT);
        a16.setBackgroundColor(Color.TRANSPARENT);
        a17.setBackgroundColor(Color.TRANSPARENT);
        a18.setBackgroundColor(Color.TRANSPARENT);
        a19.setBackgroundColor(Color.TRANSPARENT);
        a20.setBackgroundColor(Color.TRANSPARENT);
        a21.setBackgroundColor(Color.TRANSPARENT);
        a22.setBackgroundColor(Color.TRANSPARENT);
        a23.setBackgroundColor(Color.TRANSPARENT);
        a24.setBackgroundColor(Color.TRANSPARENT);
        a25.setBackgroundColor(Color.TRANSPARENT);
        a26.setBackgroundColor(Color.TRANSPARENT);
        a27.setBackgroundColor(Color.TRANSPARENT);
        a28.setBackgroundColor(Color.TRANSPARENT);

        TextView a = (TextView)v;

        a.setBackgroundColor(Color.RED);
        valor = a.getTag().toString();
    }

    public void checkear (View v){
        String spin = spinner.getSelectedItem().toString();
        res.setText("Dia: "+valor + "\n materia:"+spin+"\n");

    }
}
