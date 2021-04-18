package com.accenture.accchallenge.persistence.entity;

import java.time.LocalDateTime;
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
        listaProductos.add(new Producto(0, "Hamburguesa", 20000));
        listaProductos.add(new Producto(3, "Pizza Grandísima", 50000));
        listaProductos.add(new Producto(2, "Pasta", 25000));
        listaProductos.add(new Producto(1, "Poke", 35000));
        listaProductos.add(new Producto(4, "Sushi", 25000));
    }

    public void crearListaPedidos(){

        for(int i=0; i<listaProductos.size(); i++){
            List<Producto> listaTemp = new ArrayList<Producto>();
            for (int j=0; j<i+1; j++){
                listaTemp.add(listaProductos.get(j));
            }
            listaPedidos.add(new Pedido(i, listaTemp, LocalDateTime.now().minusHours(i*2)));
        }
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

}
