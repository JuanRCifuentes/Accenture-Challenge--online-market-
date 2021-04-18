package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepository{

    public List<Producto> getAll(){
        return AccChallengeApplication.mundo.getProductos();
    }

    public Producto getProductoByNombre(String productoName){

        System.out.print("lol");

        List<Producto> productos = AccChallengeApplication.mundo.getProductos();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(productoName)) {
                return producto;
            }
        }
        return null;
    }



}
