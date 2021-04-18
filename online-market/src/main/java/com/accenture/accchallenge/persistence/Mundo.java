package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.persistence.entity.Listas;
import com.accenture.accchallenge.persistence.entity.Pedido;
import com.accenture.accchallenge.persistence.entity.Producto;

import java.util.List;

public class Mundo {

    private List<Producto> productos;
    private List<Pedido> pedidos;

    public Mundo(){

        Listas listas = new Listas();

        productos = listas.getListaProductos();
        pedidos = listas.getListaPedidos();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
