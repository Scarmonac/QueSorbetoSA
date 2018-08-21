package com.example.steven.quesorbetosa.entidades;

public class Cliente {



    private Integer idd;
    private String nombre;
    private String telefono;
    private String PaisCliente;

    public String getPaisCliente() {
        return PaisCliente;
    }

    public void setPaisCliente(String paisCliente) {
        PaisCliente = paisCliente;
    }

    public Cliente(Integer id, String nombre, String telefono) {
        this.idd = idd;
        this.nombre = nombre;
        this.telefono = telefono;
    }


    public Cliente(){

    }

    public Integer getId() {
        return idd;
    }

    public void setId(Integer id) {
        this.idd = id;
    }

    public Integer getNombre() {
        return Integer.valueOf(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
