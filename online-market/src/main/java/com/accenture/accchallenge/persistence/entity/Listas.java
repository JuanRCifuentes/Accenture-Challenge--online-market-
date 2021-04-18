package com.accenture.accchallenge.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Listas {

    private List<Producto>  listaProductos = new ArrayList<Producto>();
    private List<Pedido>  listaPedidos = new ArrayList<Pedido>();

    public Listas(){
        crearListaProductos();
        crearListaPedidos();
    }

    public void crearListaProductos(){
        listaProductos.add(new Producto(0, "Aguacate", 2500));
        listaProductos.add(new Producto(1, "Poke", 500));
        listaProductos.add(new Producto(2, "Lechuga", 1000));
        listaProductos.add(new Producto(3, "Apio", 500));
        listaProductos.add(new Producto(4, "Sushi", 25000));
    }

    public void crearListaPedidos(){

        listaPedidos.add(new Pedido(listaProductos));
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

}
