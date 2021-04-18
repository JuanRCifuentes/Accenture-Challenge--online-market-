package com.accenture.accchallenge.domain.service;

import com.accenture.accchallenge.domain.repository.OrderRepository;
import com.accenture.accchallenge.persistence.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    public Optional<Order> updateOrder(List<Integer> products, int orderId){
        return orderRepository.updateOrder(products, orderId);
    }

    public Order getOrderById(int id){
        return orderRepository.getOrderById(id);
    }
}
