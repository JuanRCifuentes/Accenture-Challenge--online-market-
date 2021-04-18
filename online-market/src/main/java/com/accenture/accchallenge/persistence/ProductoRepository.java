package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository{

    public List<Producto> getAll(){
        return AccChallengeApplication.mundo.getProductos();
    }

    public Producto getProductoById(int productoId){

        List<Producto> productos = AccChallengeApplication.mundo.getProductos();

        for (Producto producto : productos) {
            if (producto.getProductoId() == productoId) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> getProductosById(List<Integer> pProductos){
        List <Producto> productos = new ArrayList<Producto>();

        for (int idProducto: pProductos) {
            Producto temp = getProductoById(idProducto);
            productos.add(temp);
        }
        return productos;
    }

}
