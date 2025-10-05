package com.example.switchmensaje;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Switch s1,s2;
    private Button boton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        s1 = findViewById(R.id.switch1);
        s2 = findViewById(R.id.switch2);
        boton = findViewById(R.id.button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void moviles(View v){
        if (s1.isChecked()){
            Toast.makeText(this,"datos moviles activados",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"datos moviles desactivado",Toast.LENGTH_SHORT).show();

        }
    }
    public void guifi(View v){
        if (s2.isChecked()){
            Toast.makeText(this,"wifi activo",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"wifi desactivado",Toast.LENGTH_SHORT).show();

        }

    }
    public void habilitate(View v){
        StringBuilder mensaje = new StringBuilder();
        if (s1.isChecked()){
            mensaje.append("datos moviles activados\n");
        }
        else {
            mensaje.append("datos moviles Desactivados\n");

        }
        if (s2.isChecked()){
            mensaje.append("wifi activo\n");

        }
        else {
            mensaje.append("wifi desactivado\n");

        }
        Toast.makeText(this,mensaje.toString(),Toast.LENGTH_SHORT).show();


    }
}