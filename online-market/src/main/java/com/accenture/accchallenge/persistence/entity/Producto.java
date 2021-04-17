package com.accenture.accchallenge.persistence.entity;

public class Producto {

    private String nombre;

    public Producto(String pNombre){
        nombre = pNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
