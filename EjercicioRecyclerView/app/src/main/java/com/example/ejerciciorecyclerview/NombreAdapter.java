package com.example.ejerciciorecyclerview;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class NombreAdapter extends RecyclerView.Adapter<NombreAdapter.ViewHolder>{
    private List<String> listanombres;


        public NombreAdapter(List<String> listanombres){
            this.listanombres = listanombres;

        }


    @NonNull
    @Override
    public NombreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nombre,parent,false);

            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NombreAdapter.ViewHolder holder, int position) {

            holder.texto.setText(listanombres.get(position));
    }

    @Override
    public int getItemCount() {
        return listanombres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
            TextView texto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.txtNombre);

        }
    }
}



