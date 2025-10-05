

//🧾 Ejercicio 1: Formulario Médico
//
//Objetivo: Crear un formulario de datos personales médicos.
//
//🧩 Componentes:
//
//    LinearLayout vertical.
//
//    EditText: Nombre, edad, altura.
//
//    RadioGroup: Género.
//
//    CheckBox: Alergias (polen, gluten, etc.).
//
//    Switch: ¿Toma medicación?
//
//    Button: Enviar.
//
//    TextView: Resultado.
//
//🧪 Extra sencillo:
//Coloca todo dentro de un ScrollView, así aprendes cómo scrollear contenido vertical en pantallas pequeñas.
//
//🎯 Aprendes: LinearLayout, ScrollView, entradas y controles.


package com.example.ejerciciosjavaparte2ej1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText tx1,tx2,tx3;
    private TextView resul;
    private RadioButton rad1,rad2;
    private CheckBox ch1,ch2,ch3;
    private Switch sw1;
    private Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tx1 = findViewById(R.id.t1);
        tx2 = findViewById(R.id.t2);
        tx3 = findViewById(R.id.t3);
        resul = findViewById(R.id.res);
        rad1 = findViewById(R.id.r1);
        rad2 = findViewById(R.id.r2);
        ch1 = findViewById(R.id.c1);
        ch2 = findViewById(R.id.c2);
        ch3 = findViewById(R.id.c3);
        sw1 = findViewById(R.id.switch1);
        boton = findViewById(R.id.Enviate);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void resultate (View v){
        String texto1 = tx1.getText().toString();
        String texto2 = tx2.getText().toString();
        String texto3 = tx3.getText().toString();
        String radio = "";
        if (rad1.isChecked()){
            radio = "Masculino";
        }
        if (rad2.isChecked()){
            radio = "Femenino";
        }
        String alergias = "";
        if (ch1.isChecked()){
            alergias+= "Polen,";
        }
        if (ch2.isChecked()){
            alergias+= "Gluten,";
        }
        if (ch3.isChecked()){
            alergias+= "Perros";
        }
        if (alergias== ""){
            alergias+= "Ninguna";
        }
        String Swich = "";
        if (sw1.isChecked()){
            Swich = "si";
        }
        else {
            Swich = "No";

        }
        sw1.setText(Swich);
        resul.setText("nombre: "+texto1+"\n edad: "+texto2+"\naltura"+texto3+"\ngenero"+radio+"\nalergias:"+alergias+"\ntoma medicacion:"+Swich);

    }
}