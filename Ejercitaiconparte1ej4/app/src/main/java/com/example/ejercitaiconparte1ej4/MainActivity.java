


//App 4: Formulario de registro al aquelarre digital
//
//Objetivo: Reunir todos los elementos en un solo formulario para registrar un usuario.
//
//    Componentes usados (todos los que pediste):
//
//        EditText: Nombre, edad, correo.
//
//        RadioGroup: Género.
//
//        CheckBox: Intereses.
//
//        Switch: Aceptar condiciones del inframundo.
//
//        ImageButton: Elegir avatar.
//
//        ImageView: Mostrar avatar elegido.
//
//        Button: Enviar.
//
//        TextView: Confirmación.
//
//    Extras sugeridos: Validar que todos los campos estén completos y que se haya aceptado el pacto (switch activado).


package com.example.ejercitaiconparte1ej4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText campo1,campo2,campo3;
    private RadioButton masc,fem;
    private CheckBox ch1,ch2,ch3;
    private Switch sw1;
    private ImageButton ibuton;
    private ImageView ima1;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        campo1 = findViewById(R.id.Nombre);
        campo2 = findViewById(R.id.Edad);
        campo3 = findViewById(R.id.Correo);

        masc = findViewById(R.id.hombre);
        fem = findViewById(R.id.Mujer);

        ch1 = findViewById(R.id.futbol1);
        ch2 = findViewById(R.id.basket1);
        ch3 = findViewById(R.id.Tenis1);

        sw1 = findViewById(R.id.switch1);

        ibuton = findViewById(R.id.avatar);

        ima1 = findViewById(R.id.resulavatar);

        desc = findViewById(R.id.Descripcion);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void enviate(View v){

        String name = campo1.getText().toString();
        String years = campo2.getText().toString();
        String email = campo3.getText().toString();
        String genero = "";
        String gustos = "";
        if(masc.isChecked()){
            genero = "masculino";
        }
        if (fem.isChecked()){
            genero = "femenino";
        }
        if (ch1.isChecked()){
            gustos+="futbol";
        }
        if (ch2.isChecked()){
            gustos+="basket";
        }
        if (ch3.isChecked()){
            gustos+="tenis";
        }
        if (gustos == ""){
            gustos = "ninguno";
        }

        if (sw1.isChecked()){
            desc.setText("contrato aceptado");
        }
        else {
            desc.setText("no has aceptado el contrato mortal");
        }

    }

    public void imageclick(View v){

        ima1.setImageResource(R.drawable.d1);
    }

    public void suich (View v){
        if (sw1.isChecked()){
        sw1.setText("acepto");
        }
        else {
            sw1.setText("no acepto");
        }


    }


}