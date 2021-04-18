package com.accenture.accchallenge.domain.repository;

import com.accenture.accchallenge.persistence.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAllOrders();
    Optional<Order> updateOrder(List<Integer> products, int orderId);
    Order getOrderById(int id);

}
