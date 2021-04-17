package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.persistence.entity.Producto;

public class Mundo {

    private String nombre = "Juan";
    private Producto producto;

    public Mundo(){
        producto = new Producto(nombre);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
