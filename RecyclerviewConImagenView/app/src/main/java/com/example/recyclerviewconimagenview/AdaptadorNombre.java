package com.example.recyclerviewconimagenview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorNombre extends RecyclerView.Adapter<AdaptadorNombre.Viewholder> {

    private List <item>listitas;

    public AdaptadorNombre(List <item> listitas){
        this.listitas=listitas;

    }

    @NonNull
    @Override
    public AdaptadorNombre.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nombres,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorNombre.Viewholder holder, int position) {
        item items = listitas.get(position); //tenemos que crearlo asi porque viene todo junto
        holder.texto.setText(items.getPalabra());
        holder.imagen.setImageResource(items.getImagen());


    }

    @Override
    public int getItemCount() {
        return listitas.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder{

        TextView texto;
        ImageView imagen;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.itemtexto);
            imagen = itemView.findViewById(R.id.imagencita);
        }
    }
}
