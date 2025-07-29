package com.example.ejerciciofacturacion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table mercaderia (ID_Mercaderia INTEGER primary key AUTOINCREMENT,Nombre text,Precio INTEGER,Cantidad INTEGER,Descuento INTEGER)");
        db.execSQL("create table clientes (ID_Cliente INTEGER primary key AUTOINCREMENT,Nombre text,Apellido text,DNI INTEGER,Domicilio text)");
        db.execSQL("create table proveedores (ID_Proveedor INTEGER primary key AUTOINCREMENT,Nombre text,CUIT text,Domicilio text)");
        db.execSQL("create table usuarios (ID_Usuario INTEGER primary key AUTOINCREMENT,Usuario text,Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
