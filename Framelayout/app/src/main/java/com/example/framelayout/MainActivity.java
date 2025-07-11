package com.example.framelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageButton i1,i2,i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        i1 = findViewById(R.id.imageButton4);
        i2 = findViewById(R.id.imageButton5);
        i3 = findViewById(R.id.imageButton6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cambio(View v){

        ImageButton i = (ImageButton)v;

        i.setVisibility(View.INVISIBLE);
    }


    public void regenera(View v){

        i1.setVisibility(View.VISIBLE);
        i2.setVisibility(View.VISIBLE);
        i3.setVisibility(View.VISIBLE);


    }
}