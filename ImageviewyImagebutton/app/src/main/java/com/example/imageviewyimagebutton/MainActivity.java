package com.example.imageviewyimagebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton boton;
    private ImageView dado1,dado2,dado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.b1);
        dado1 = findViewById(R.id.i1);
        dado2 = findViewById(R.id.i2);
        dado3 = findViewById(R.id.i3);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void tirada (View v){
        int valor1 = 1+(int)(Math.random()*3);
        int valor2 = 1+(int)(Math.random()*3);
        int valor3 = 1+(int)(Math.random()*3);
        switch (valor1){

            case 1:
                dado1.setImageResource(R.drawable.d1);
                break;
            case 2:
                dado1.setImageResource(R.drawable.d2);
                break;
            case 3:
                dado1.setImageResource(R.drawable.d3);
                break;
        }
        switch (valor2){

            case 1:
                dado2.setImageResource(R.drawable.d1);
                break;
            case 2:
                dado2.setImageResource(R.drawable.d2);
                break;
            case 3:
                dado2.setImageResource(R.drawable.d3);
                break;
        }
        switch (valor3){

            case 1:
                dado3.setImageResource(R.drawable.d1);
                break;
            case 2:
                dado3.setImageResource(R.drawable.d2);
                break;
            case 3:
                dado3.setImageResource(R.drawable.d3);
                break;
        }




    }
}