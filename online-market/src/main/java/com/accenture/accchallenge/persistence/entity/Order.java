package com.accenture.accchallenge.persistence.entity;

import com.accenture.accchallenge.persistence.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    @Autowired
    private ProductRepo productRepo;

    final BigDecimal priceForNoShipping = new BigDecimal("100000");

    private Integer orderId;
    private List<Product> products;
    private LocalDateTime creationDate;
    private BigDecimal subtotal;
    private BigDecimal shipping;
    private BigDecimal total;

    public Order(Integer pId, List<Product> pProducts, LocalDateTime pDate){
        orderId = pId;
        products = pProducts;
        calculateSubtotal();
        calculateShipping();
        calculateTotal();
        creationDate = pDate;
    }

//    ----------------------- METHODS -----------------------

    public void calculateTotal(){
        total = subtotal.add(shipping);
    }

    public void calculateShipping(){
        shipping = priceForNoShipping.compareTo(subtotal)==1 ? new BigDecimal("5000") : new BigDecimal("0");
    }

    public void calculateSubtotal(){
        subtotal = new BigDecimal("0");
        for (Product product : products) {
            subtotal = subtotal.add(product.getPrice());
        }
    }

//     --------------- SETTERS AND GETTERS ------------------

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
