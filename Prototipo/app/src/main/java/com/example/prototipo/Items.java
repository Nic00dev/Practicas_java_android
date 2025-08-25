package com.example.prototipo;
public class Items {
    public String Nombre1;
    public String Imagen1;
    public String id;
    public Items(String nombre, String Imagen,String id) {
        this.Nombre1 = nombre;
        this.Imagen1 = Imagen;
        this.id = id;

    }

    public String getNombre(){

        return Nombre1;
    }
    public String getImagenUrl(){

        return Imagen1;
    }

    public String getId() {
        return id;
    }
}