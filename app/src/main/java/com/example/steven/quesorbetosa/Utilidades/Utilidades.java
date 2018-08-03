package com.example.steven.quesorbetosa.Utilidades;

public class Utilidades {

    //Constantes campos tabla CLIENTE
    public static final String TABLA_CLIENTE="Cliente";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_TELEFONO="telefono";


    public static final String CREAR_TABLA_CLIENTE="CREATE TABLE " +
            ""+TABLA_CLIENTE+" ("+CAMPO_ID+" " +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_TELEFONO+" TEXT)";

//Constantes campos tabla PRODUCTO

    public static final String TABLA_PRODUCTO="Producto";
    public static final String CAMPO_ID_PRODUCTO="id";
    public static final String CAMPO_NOMBRE_PRODUCTO="nombre";
    public static final String CAMPO_PRECIO_VENTA="Precio_venta";

    public static final String CREAR_TABLA_PRODUCTO="CREATE TABLE " +
            ""+TABLA_PRODUCTO+" ("+CAMPO_ID_PRODUCTO+" " +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE_PRODUCTO+" TEXT,"+CAMPO_PRECIO_VENTA+" TEXT)";
}

