package com.example.steven.quesorbetosa.entidades;

public class Producto {



    private Integer idd;
    private String nombre;
    private Integer precio_venta;


    public Producto(Integer id, String nombre, Integer precio_venta) {
        this.idd = idd;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
    }


    public Producto(){

    }



    public void setId(Integer id) {
        this.idd = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio_venta() {
        return precio_venta;
    }

    public void setTelefono(Integer precio_venta) {
        this.precio_venta = precio_venta;
    }
}
