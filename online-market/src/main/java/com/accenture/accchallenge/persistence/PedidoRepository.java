package com.accenture.accchallenge.persistence;

import ch.qos.logback.core.rolling.helper.PeriodicityType;
import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.persistence.entity.Pedido;
import com.accenture.accchallenge.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Pedido> getAll(){
        return AccChallengeApplication.mundo.getPedidos();
    }

    public Pedido actualizarPedido(List<Integer> productos, int pedidoId){

        Pedido pedido = getPedidoById(pedidoId);
        List<Producto> productosNuevos = productoRepository.getProductosById(productos);
        Pedido pedidoTemp = new Pedido(1, productosNuevos, LocalDateTime.now());

        Boolean aumentoPrecio = pedidoTemp.getSubtotal().compareTo(pedido.getSubtotal())==1 ||
                pedidoTemp.getSubtotal().compareTo(pedido.getSubtotal())==0;

        long hours = ChronoUnit.HOURS.between(pedido.getFechaCreacion(), pedidoTemp.getFechaCreacion());
        Boolean esReciente = hours < 5;

        if(aumentoPrecio && esReciente){
            pedido.setProductos(productosNuevos);
            pedido.calcularSubtotal();
            pedido.calcularDomicilio();
            pedido.calcularTotal();
            return pedido;

        } else {
            return null;
        }

    }

    public Pedido getPedidoById(int pedidoId){

        List<Pedido> pedidos = AccChallengeApplication.mundo.getPedidos();

        for (Pedido pedido : pedidos) {
            if (pedido.getPedidoId() == pedidoId) {
                return pedido;
            }
        }
        return null;
    }

}
