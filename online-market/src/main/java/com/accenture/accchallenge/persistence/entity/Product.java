package com.accenture.accchallenge.persistence.entity;

import java.math.BigDecimal;

public class Product {

    private int productId;
    private String name;
    private BigDecimal price;

    public Product(int pId, String pName, int pPrice){
        productId = pId;
        name = pName;
        price = new BigDecimal(pPrice);
    }

    //     --------------- SETTERS AND GETTERS ------------------

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
