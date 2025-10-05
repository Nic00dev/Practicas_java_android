

//App 2: Encuesta de gustos
//
//Objetivo: Capturar varias opciones usando RadioGroup, CheckBox y Switch, y mostrar la selección en un TextView.
//
//    Componentes usados:
//
//        RadioGroup + RadioButtons: Selección de género musical favorito.
//
//        CheckBox: Gustos adicionales (leer, videojuegos, deporte...).
//
//        Switch: ¿Quieres recibir notificaciones?
//
//        Button: Enviar encuesta.
//
//        TextView: Mostrar resumen.
//
//    Contenido extra: Usar Toast o AlertDialog para confirmar el envío.

package com.example.ejercitacionparte1ej2;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioButton r1,r2,r3;
    private CheckBox c1,c2,c3;
    private Switch s1;
    private TextView t1;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.genero1);
        r2 = findViewById(R.id.genero2);
        r3 = findViewById(R.id.genero3);

        c1 = findViewById(R.id.gusto1);
        c2 = findViewById(R.id.gusto2);
        c3 = findViewById(R.id.gusto3);

        s1 = findViewById(R.id.switch1);
        t1 = findViewById(R.id.res1);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void noti (View v){
        if (s1.isChecked()){
            s1.setText("si");

        }
        else {
            s1.setText("no");
        }

    }
    public void enviate (View v){

        String genero = "";
        String gusto = "";
        String notificaciones = "";
        if (r1.isChecked()){
            genero = "rock";
        }
        else if (r2.isChecked()){
            genero = "Jazz";
        }
        else if (r3.isChecked()){
            genero = "Opera";
        }
        else {
            genero = "ninguno";
        }
        if (c1.isChecked()){
            gusto += "futbol";
        }
        if (c2.isChecked()){
            gusto += "basket";
        }
        if (c3.isChecked()){
            gusto += "tenis";
        }
        if (gusto == ""){
            gusto = "ninguno";
        }
        if (s1.isChecked()){
            notificaciones = "Si";
        }
        else {
            notificaciones = "No";
        }
        t1.setText("Genero:" + genero + "\n Gustos adicionales:"+gusto+"\n Notificaciones: "+ notificaciones);
        Toast.makeText(this,"Genero:" + genero + "\n Gustos adicionales:"+gusto+"\n Notificaciones: "+ notificaciones,Toast.LENGTH_SHORT).show();
    }



}