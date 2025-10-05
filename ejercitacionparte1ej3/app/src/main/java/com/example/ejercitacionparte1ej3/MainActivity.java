
//App 3: Selector de mascota infernal
//
//Objetivo: Seleccionar una mascota con ImageButtons y mostrarla en un ImageView junto con su descripción en un TextView.
//
//    Componentes usados:
//
//        ImageButtons: Perro, gato, dragón, cabra de Satán...
//
//        ImageView: Mostrar la imagen elegida.
//
//        TextView: Descripción breve.
//
//        Button: Confirmar elección.
//
//        (Opcional: Toast que diga "¡Has elegido sabiamente!" o no).

package com.example.ejercitacionparte1ej3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageButton pe,ga,dra,cab;
    private ImageView ima;
    private TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pe = findViewById(R.id.perro);
        ga = findViewById(R.id.gato);
        dra = findViewById(R.id.dragon);
        cab = findViewById(R.id.cabra);

        ima = findViewById(R.id.resul);
        desc = findViewById(R.id.describe);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void dog(View v){
        ima.setImageResource(R.drawable.perro);
        desc.setText("has seleccionado un perro");
    }
    public void cat(View v){
        ima.setImageResource(R.drawable.gatito);
        desc.setText("has seleccionado un gato");

    }
    public void drake(View v){
        ima.setImageResource(R.drawable.dragon);
        desc.setText("has seleccionado un dragon");

    }
    public void cow(View v){
        ima.setImageResource(R.drawable.cabrasatan);
        desc.setText("has seleccionado una cabrad e satan");

    }

    public void envio(View v){
        Toast.makeText(this,"finalizado",Toast.LENGTH_SHORT).show();

    }
}