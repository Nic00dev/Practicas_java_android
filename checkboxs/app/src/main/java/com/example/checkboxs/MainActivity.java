package com.example.checkboxs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText campo1,campo2;
    private CheckBox checks1,checks2;
    private TextView resultadotexto;
    private Button operarbuttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        campo1 = findViewById(R.id.c1);
        campo2 = findViewById(R.id.c2);
        checks1=findViewById(R.id.check1);
        checks2=findViewById(R.id.check2);
        resultadotexto= findViewById(R.id.resultadotext);
        operarbuttons=findViewById(R.id.operarboton);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void operate (View v){

        String cam1 = campo1.getText().toString();
        String cam2 = campo2.getText().toString();
        int cam1int = Integer.parseInt(cam1);
        int cam2int = Integer.parseInt(cam2);
        int resultante = 0;
        String resu = "";
        if (checks1.isChecked()){
            resultante = cam1int+cam2int;
            resu = resu+resultante;
        }
        if(checks2.isChecked()){
            resultante = cam1int-cam2int;
            resu = resu+resultante;

        }
        resultadotexto.setText("el resultado es: " + resu);
    }
}