package com.example.controlspinnerconlistastring;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1,num2;
    private Button op;

    private Spinner lista;
    private TextView resulta;
    private String [] operaciones = {"sumar","restar","multiplicar","dividir"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.n1);
        num2 = findViewById(R.id.n2);
        op = findViewById(R.id.Operar);
        resulta = findViewById(R.id.res);
        lista = findViewById(R.id.spinner);

        ArrayAdapter <String> adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operaciones);
        lista.setAdapter(adaptador1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void operate (View v){

        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();
        int resultado = 0;
        int n1int = Integer.parseInt(n1);
        int n2int = Integer.parseInt(n2);
        String operacion = lista.getSelectedItem().toString();

        if (operacion == "sumar"){
            resultado = n1int+n2int;
            resulta.setText("Resultado: "+resultado);

        }
        if (operacion == "restar"){
            resultado = n1int-n2int;
            resulta.setText("Resultado: "+resultado);

        }
        if (operacion == "multiplicar"){
            resultado = n1int*n2int;
            resulta.setText("Resultado: "+resultado);

        }
        if (operacion == "dividir"){
            resultado = n1int/n2int;
            resulta.setText("Resultado: "+resultado);

        }


    }

}