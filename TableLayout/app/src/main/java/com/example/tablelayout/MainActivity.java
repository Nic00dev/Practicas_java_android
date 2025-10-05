package com.example.tablelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,salir;
    private String jugador = "x";
    private String jugador2 = "o";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        a1 = findViewById(R.id.b1);
        a2 = findViewById(R.id.b2);
        a3 = findViewById(R.id.b3);
        a4 = findViewById(R.id.b4);
        a5 = findViewById(R.id.b5);
        a6 = findViewById(R.id.b6);
        a7 = findViewById(R.id.b7);
        a8 = findViewById(R.id.b8);
        a9 = findViewById(R.id.b9);
        salir = findViewById(R.id.salte);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void tirar (View v){
        Button b =(Button)v; //esto hace que hagas referencia a el button

        if (b.getText() == ""){
            b.setText(jugador);
        }
        verificar(jugador);

        cambiarjugador();


    }

    public void verificar(String turno) {
        String casilla1 = a1.getText().toString();
        String casilla2 = a2.getText().toString();
        String casilla3 = a3.getText().toString();
        String casilla4 = a4.getText().toString();
        String casilla5 = a5.getText().toString();
        String casilla6 = a6.getText().toString();
        String casilla7 = a7.getText().toString();
        String casilla8 = a8.getText().toString();
        String casilla9 = a9.getText().toString();

        if (casilla1.equals(turno) && casilla2.equals(turno) && casilla3.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();

        }
        if (casilla4.equals(turno) && casilla5.equals(turno) && casilla6.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();
        }
        if (casilla7.equals(turno) && casilla8.equals(turno) && casilla9.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();
        }
        if (casilla1.equals(turno) && casilla5.equals(turno) && casilla9.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();
        }
        if (casilla3.equals(turno) && casilla5.equals(turno) && casilla7.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();
        }
        if (casilla1.equals(turno) && casilla4.equals(turno) && casilla7.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();
        }
        if (casilla2.equals(turno) && casilla5.equals(turno) && casilla8.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();
        }
        if (casilla3.equals(turno) && casilla6.equals(turno) && casilla9.equals(turno)){
            Toast.makeText(this, "victoria", Toast.LENGTH_SHORT).show();
            apagar();
        }



    }

    public void cambiarjugador() {

        if (jugador == "x"){
            jugador = "o";
        }
        else{
            jugador = "x";
        }

    }

    public void apagar (){
        a1.setEnabled(false);
        a2.setEnabled(false); //esto apaga botoens
        a3.setEnabled(false);
        a4.setEnabled(false);
        a5.setEnabled(false);
        a6.setEnabled(false);
        a7.setEnabled(false);
        a8.setEnabled(false);
        a9.setEnabled(false);

    }
}