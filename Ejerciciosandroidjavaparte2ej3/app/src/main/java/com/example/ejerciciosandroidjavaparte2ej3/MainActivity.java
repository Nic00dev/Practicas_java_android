
//🧾 Ejercicio 3: Galería oculta de mascotas infernales
//
//Objetivo: Seleccionar y mostrar distintas mascotas con imágenes y datos.
//
//🧩 Componentes:
//
//    FrameLayout: Contenedor que oculta/visualiza una imagen a la vez.
//
//    ImageButtons: Cambiar de mascota.
//
//    ImageView: Mostrar al familiar elegido.
//
//    TextView: Breve descripción.
//
//    Button: “Elegir como compañero”.
//
//🧪 Extra sencillo:
//Al confirmar, muestra un Toast con el nombre del compañero invocado.
//
//🎯 Aprendes: FrameLayout para superposición o reemplazo de vistas, manejo de imágenes y selección.


package com.example.ejerciciosandroidjavaparte2ej3;

import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView im;
    private ImageButton b1,b2,b3;
    private TextView tv;
    private int contador = 0;
    private String nombre = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tex);
        im = findViewById(R.id.imagen);
        b1 = findViewById(R.id.imageButton4);
        b2 = findViewById(R.id.imageButton5);
        b3 = findViewById(R.id.imageButton6);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cambio (View v){
        ImageButton i = (ImageButton)v;
        i.setVisibility(View.INVISIBLE);
        contador = contador+1;
        if (contador == 0){
            nombre = "dado 1";
        }
        if (contador == 1){
            nombre = "dado 2";
        }
        if (contador == 2){
            nombre = "dado3";
        }
        if (contador == 3){
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            contador = 0;
            nombre = "ninguno";
        }



    }
    public  void enviar (View v){
        if (contador == 0){
            im.setImageResource(R.drawable.d1);
            tv.setText("seleccionado el dado 1");
            Toast.makeText(this,"has seleccionado el dado 1",Toast.LENGTH_SHORT).show();}
        if (contador == 1){
            im.setImageResource(R.drawable.d2);
            makeText(this,"has seleccionado el dado 2",Toast.LENGTH_SHORT).show();
            tv.setText("seleccionado el dado 2");}
        if (contador == 2){
            im.setImageResource(R.drawable.d3);
            makeText(this,"has seleccionado el dado 3",Toast.LENGTH_SHORT).show();
            tv.setText("seleccionado el dado 3");}

    }
}