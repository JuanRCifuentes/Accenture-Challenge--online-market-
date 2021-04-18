package com.accenture.accchallenge.persistence.entity;

import com.accenture.accchallenge.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    @Autowired
    private ProductoRepository productoRepository;

    final BigDecimal valorNoDomicilio = new BigDecimal("100000");

    private Integer pedidoId;
    private List<Producto> productos;
    private LocalDateTime fechaCreacion;
    private BigDecimal subtotal;
    private BigDecimal total;
    private BigDecimal costoDomicilio;

    public Pedido(List<String> pProductos, List<Producto> listaProductos){
        pedidoId = 1;
        addProductos(pProductos, listaProductos);
        subtotal = new BigDecimal("10");
        costoDomicilio = new BigDecimal("5");
        total = subtotal.add(costoDomicilio);
        fechaCreacion = LocalDateTime.now();
    }

//    ----------------------- METHODS -----------------------

    public void addProductos(List<String> pProductos, List<Producto> listaProductos){
        productos = new ArrayList<Producto>();

        for (String nombreProducto: pProductos) {
            System.out.println("entró al for");
            Producto temp = productoRepository.getProductoByNombre(nombreProducto);
            productos.add(temp);
        }
    }

//     --------------- SETTERS AND GETTERS ------------------

    public BigDecimal getValorNoDomicilio() {
        return valorNoDomicilio;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getCostoDomicilio() {
        return costoDomicilio;
    }

    public void setCostoDomicilio(BigDecimal costoDomicilio) {
        this.costoDomicilio = costoDomicilio;
    }
}
