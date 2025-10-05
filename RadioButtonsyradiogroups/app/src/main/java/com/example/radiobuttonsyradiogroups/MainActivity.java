package com.example.radiobuttonsyradiogroups;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText campo1;
    //el hint de common atributes pone texto en gris fondo
    private EditText campo2;
    private TextView campoResultado;
    private RadioButton botonsumar;
    private RadioButton botonrestar;
    private Button botonoperar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        campo1 = findViewById(R.id.edit1);
        campo2 = findViewById(R.id.edit2);
        campoResultado = findViewById(R.id.Resultado);
        botonsumar = findViewById(R.id.fr1);
        botonrestar= findViewById(R.id.fr2);
        botonoperar=findViewById(R.id.button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Operar (View v) {

        String c1 =campo1.getText().toString();
        String c2 = campo2.getText().toString();
        int c1s = Integer.parseInt(c1);
        int c2s = Integer.parseInt(c2);

        if (botonsumar.isChecked()){ //esto verifica si esta seleccionado o no el radiobutton,el radio group meter radiobutons dentro
            int resultante = c1s + c2s;
            campoResultado.setText("resultado"+resultante);
        }
        else {if (botonrestar.isChecked()){

            int resultante = c1s - c2s;
            campoResultado.setText("resultado"+resultante);
        }}


    }


}