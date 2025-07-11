/*
🧾 Ejercicio 4: Registro académico con Scroll + Spinner

Objetivo: Formulario largo para registrar a un estudiante.

🧩 Componentes:

    ScrollView: Para tdo el contenido.

    LinearLayout vertical.

    EditText: Nombre, edad, nacionalidad.

    Spinner: Carrera (Informática, Biología, Filosofía…).

    CheckBox: Intereses extracurriculares.

    Switch: ¿Desea beca?

    RadioGroup: Modalidad de cursado (Presencial / Virtual).

    Button: Enviar.

    TextView: Resumen de inscripción.

🧪 Extra sencillo:
Cuando se pulsa "Enviar", mostrar toda la información resumida en un AlertDialog.

🎯 Aprendes: Spinner, formularios largos, resumen de datos, alertas.
*/


package com.example.ejerciciosjavaparte2ej4;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText e1,e2,e3;
    private RadioButton r1,r2;
    private Switch s1;

    private CheckBox c1,c2,c3;
    private Spinner spinner;
    private TextView tv;
    private String [] carreras = {"Informatica","Biologia","filosofia"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText3);
        e3 = findViewById(R.id.editTextText2);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        s1 = findViewById(R.id.switch1);
        c1 = findViewById(R.id.checkBox3);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox);
        spinner = findViewById(R.id.spin);
        tv = findViewById(R.id.textView2);


        ArrayAdapter<String>adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,carreras);
        spinner.setAdapter(adaptador1);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviar (View v){
        String nombre = e1.getText().toString();
        String edad = e2.getText().toString();
        String nacionalidad = e3.getText().toString();
        String modalidad = "";
        String beca = "no";
        String extra = "";
        String carreras = spinner.getSelectedItem().toString();
        if (r1.isChecked()){
            modalidad = "presencial";
        }
        if (r2.isChecked()){
            modalidad = "virtual";
        }
        if (s1.isChecked()){
            beca = "si";
            s1.setText("si");
        }
        else {beca = "no";
            s1.setText("no");}
        if (c1.isChecked()){
            extra += "futbol";
        }
        if (c2.isChecked()){
            extra += "basket";
        }
        if (c3.isChecked()){
            extra += "tenis";
        }

        tv.setText(
                "Nombre: " + nombre + "\n" +
                        "Edad: " + edad + "\n" +
                        "Nacionalidad: " + nacionalidad + "\n" +
                        "Modalidad: " + modalidad + "\n" +
                        "Beca: " + beca + "\n" +
                        "Extra: " + extra + "\n" +
                        "Carrera seleccionada: " + carreras
        );
        // Mostrar resumen en AlertDialog
        String resumen = "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Nacionalidad: " + nacionalidad + "\n" +
                "Modalidad: " + modalidad + "\n" +
                "Beca: " + beca + "\n" +
                "Extra: " + extra + "\n" +
                "Carrera seleccionada: " + carreras;

        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Resumen de inscripción")
                .setMessage(resumen)
                .setPositiveButton("Aceptar", null)
                .show();




    }
}