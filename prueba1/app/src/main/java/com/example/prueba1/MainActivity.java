package com.example.prueba1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView titulo1;
    EditText campo1,campo2;
    Button aceptar;
    TextView resultado;
    String num1,num2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        titulo1 = findViewById(R.id.titulo);
        campo1 = findViewById(R.id.editTextText);
        campo2 = findViewById(R.id.editTextText2);
        aceptar = findViewById(R.id.button);
        resultado= findViewById(R.id.textView2resultado);
        campo1.setText("");
        campo2.setText("");


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                num1 = String.valueOf(campo1.getText());
                num2 = String.valueOf(campo2.getText());
                campo1.setText("kiko");
                campo2.setText("ron damon");
                titulo1.setText("boton apretado");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void sumate(){
        num1 = String.valueOf(campo1.getText());
        num2 = String.valueOf(campo2.getText());
        int num1I = Integer.parseInt(num1);
        int num2I = Integer.parseInt(num1);

        int sumatoria = num1I + num2I;
        resultado.setText(sumatoria);

    }

    public void restate(){
        num1 = String.valueOf(campo1.getText());
        num2 = String.valueOf(campo2.getText());
        int num1I = Integer.parseInt(num1);
        int num2I = Integer.parseInt(num1);

        int restatoria = num1I + num2I;
        resultado.setText(restatoria);

    }


}