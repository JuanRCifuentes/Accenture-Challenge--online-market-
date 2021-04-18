package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.persistence.entity.Pedido;
import com.accenture.accchallenge.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Pedido> getAll(){
        return AccChallengeApplication.mundo.getPedidos();
    }

    public List<Producto> addProductos(List<String> pProductos){
        List <Producto> productos = new ArrayList<Producto>();

        for (String nombreProducto: pProductos) {
            System.out.println("entró al for");
            Producto temp = productoRepository.getProductoByNombre(nombreProducto);
            productos.add(temp);
        }
        return productos;
    }

}
