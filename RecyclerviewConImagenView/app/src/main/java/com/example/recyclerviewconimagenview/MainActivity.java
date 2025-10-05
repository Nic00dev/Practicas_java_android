package com.example.recyclerviewconimagenview;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<item> listaItems;
    private RecyclerView recyclerView;
    private AdaptadorNombre adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewa);

        listaItems = new ArrayList<>();
        listaItems.add(new item("Primer ítem", R.drawable.ic_launcher_foreground));
        listaItems.add(new item("Segundo ítem", R.drawable.ic_launcher_background));
        listaItems.add(new item("Tercer ítem", R.drawable.ic_launcher_foreground));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdaptadorNombre(listaItems);
        recyclerView.setAdapter(adapter);

    }
}