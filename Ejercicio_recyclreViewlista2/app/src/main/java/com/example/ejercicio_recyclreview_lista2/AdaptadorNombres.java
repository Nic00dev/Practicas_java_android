package com.example.ejercicio_recyclreview_lista2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class AdaptadorNombres extends RecyclerView.Adapter<AdaptadorNombres.ViewHolder>{

    private List <String>listita;

    public AdaptadorNombres(List <String>listita){
        this.listita=listita;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nombre,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.texto.setText(listita.get(position));
    }

    @Override
    public int getItemCount() {
        return listita.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView texto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.textito1);
        }
    }
}