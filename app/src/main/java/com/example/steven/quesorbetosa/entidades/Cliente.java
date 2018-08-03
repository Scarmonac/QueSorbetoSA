package com.example.steven.quesorbetosa.entidades;

public class Cliente {



    private Integer idd;
    private Integer nombre;
    private Integer telefono;

    public Cliente(Integer id, Integer nombre, Integer telefono) {
        this.idd = idd;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getId() {
        return idd;
    }

    public void setId(Integer id) {
        this.idd = id;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
