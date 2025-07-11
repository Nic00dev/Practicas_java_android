package com.example.controlspinnerconitemscompuestosporunaimagenyuntextview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private TextView t1;
    private Spinner spin;
    private Button button;
    private String [] paises = {"argentina","chile","bolivia"};
    private int [] banderas = {R.drawable.argentina,R.drawable.chile,R.drawable.bolivia};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.texto1);
        spin = findViewById(R.id.spinner);
        button = findViewById(R.id.boton);

        PaisesAdapter adaptador1 = new PaisesAdapter();
        spin.setAdapter(adaptador1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void enviar (View v){

        Toast.makeText(this,spin.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    public class PaisesAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return paises.length;
        }

        @Override
        public Object getItem(int position) {
            return paises[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertView = inflater.inflate(R.layout.itemsspinner,null);
            ImageView i1 = convertView.findViewById(R.id.imageView);
            TextView t1 = convertView.findViewById(R.id.Nombre);
            i1.setImageResource(banderas[position]);
            t1.setText(paises[position]);
            return convertView;
        }
    }
}

