package com.example.recyclerviewconimagenview;

public class item {
    private String palabra;
    private  int imagen;

    public item (String palabra,int imagen){
        this.imagen = imagen;
        this.palabra = palabra;


    }

    public int getImagen() {
        return imagen;
    }

    public String getPalabra() {
        return palabra;
    }
}
