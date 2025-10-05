package com.example.prototipo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class Adaptador_lista extends RecyclerView.Adapter<Adaptador_lista.Viewholder> {

    private List<Items> lista_pokemon;

    public Adaptador_lista(List<Items> lista_pokemon){
        this.lista_pokemon=lista_pokemon;


    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_layout,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int index = position * 3;

        if (index < lista_pokemon.size()) {
            Items item1 = lista_pokemon.get(index);
            holder.Nombre_pokemon_1.setText(item1.getNombre());
            Glide.with(holder.itemView.getContext())
                    .load(item1.getImagenUrl())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.imagen_pokemon_1);
        }

        if (index + 1 < lista_pokemon.size()) {
            Items item2 = lista_pokemon.get(index + 1);
            holder.Nombre_pokemon_2.setText(item2.getNombre());
            Glide.with(holder.itemView.getContext())
                    .load(item2.getImagenUrl())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.imagen_pokemon_2);
        }

        if (index + 2 < lista_pokemon.size()) {
            Items item3 = lista_pokemon.get(index + 2);
            holder.Nombre_pokemon_3.setText(item3.getNombre());
            Glide.with(holder.itemView.getContext())
                    .load(item3.getImagenUrl())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.imagen_pokemon_3);
        }

        // Listeners
        holder.imagen_pokemon_1.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, Descripcion_pokemon.class);
            context.startActivity(intent);
        });

        holder.imagen_pokemon_2.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, Descripcion_pokemon.class);
            context.startActivity(intent);
        });

        holder.imagen_pokemon_3.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, Descripcion_pokemon.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {

        return (int) Math.ceil(lista_pokemon.size() / 3.0);
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        ImageView imagen_pokemon_1;
        ImageView imagen_pokemon_2;
        ImageView imagen_pokemon_3;
        TextView Nombre_pokemon_1;
        TextView Nombre_pokemon_2;
        TextView Nombre_pokemon_3;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Nombre_pokemon_1= itemView.findViewById(R.id.textView);
            Nombre_pokemon_2=itemView.findViewById(R.id.textView2);
            Nombre_pokemon_3=itemView.findViewById(R.id.textView3);
            imagen_pokemon_3= itemView.findViewById(R.id.imageView2);
            imagen_pokemon_2= itemView.findViewById(R.id.imageView3);
            imagen_pokemon_1= itemView.findViewById(R.id.imageView4);



        }
    }
}
