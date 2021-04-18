package com.accenture.accchallenge.persistence.entity;

import java.math.BigDecimal;

public class Producto {

    private int productoId;
    private String nombre;
    private BigDecimal precio;

    public Producto(int pId, String pNombre, int pPrecio){
        productoId = pId;
        nombre = pNombre;
        precio = new BigDecimal(pPrecio);
    }

    //    ----------------------- METHODS -----------------------

    //     --------------- SETTERS AND GETTERS ------------------

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
