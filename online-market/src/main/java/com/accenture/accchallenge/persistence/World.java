package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.persistence.entity.Lists;
import com.accenture.accchallenge.persistence.entity.Order;
import com.accenture.accchallenge.persistence.entity.Product;

import java.util.List;

public class World {

    private List<Product> products;
    private List<Order> orders;

    public World(){

        Lists lists = new Lists();

        products = lists.getProductsList();
        orders = lists.getOrdersList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
