
//Nivel 1 – Invocaciones básicas de UI
//App 1: Calculadora de edad
//
//Objetivo: Capturar datos de un EditText (año de nacimiento) y mostrar la edad calculada en un TextView al presionar un Button.
//
//    Componentes usados:
//
//        EditText: Ingresar año de nacimiento.
//
//        Button: Calcular.
//
//        TextView: Mostrar resultado.
//
//    Extras sugeridos: Validación de entrada (¡no naciste en el 3022, humano!).





package com.example.ejercitacionparte1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText campo1,campo2;
    private TextView texto1,demonio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        campo1 = findViewById(R.id.anio);
        campo2= findViewById(R.id.actual);
        texto1 = findViewById(R.id.resultado);
        demonio = findViewById(R.id.vigilante);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculo(View v){

        String c1 = campo1.getText().toString();
        String c2 = campo2.getText().toString();
        int c1int = Integer.parseInt(c1);
        int c2int = Integer.parseInt(c2);
        int cresultado = 0;

        cresultado = c2int-c1int;

        if (c1int>3000){
            demonio.setText("Demonio Vigilante: MORTAL NO NACISTE EN EL AÑO "+ c1int);
            texto1.setText(""+cresultado);
        }
        else{
            demonio.setText("Demonio Vigilante: nada raro por aqui mortal");
            texto1.setText(""+cresultado);
        }






    }
}