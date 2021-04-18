package com.accenture.accchallenge.persistence.entity;

import com.accenture.accchallenge.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    @Autowired
    private ProductoRepository productoRepository;

    final BigDecimal valorNoDomicilio = new BigDecimal("100000");

    private Integer pedidoId;
    private List<Producto> productos;
    private LocalDateTime fechaCreacion;
    private BigDecimal subtotal;
    private BigDecimal costoDomicilio;
    private BigDecimal total;

    public Pedido(Integer id, List<Producto> pProductos, LocalDateTime pFecha){
        pedidoId = id;
        productos = pProductos;
        calcularSubtotal();
        calcularDomicilio();
        calcularTotal();
        fechaCreacion = pFecha;
    }

//    ----------------------- METHODS -----------------------

    public void calcularTotal(){
        total = subtotal.add(costoDomicilio);
    }

    public void calcularDomicilio(){
        costoDomicilio = valorNoDomicilio.compareTo(subtotal)==1 ? new BigDecimal("5000") : new BigDecimal("0");
    }

    public void calcularSubtotal(){
        subtotal = new BigDecimal("0");
        for (Producto producto: productos) {
            subtotal = subtotal.add(producto.getPrecio());
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

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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

    public BigDecimal getCostoDomicilio() {
        return costoDomicilio;
    }

    public void setCostoDomicilio(BigDecimal costoDomicilio) {
        this.costoDomicilio = costoDomicilio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
