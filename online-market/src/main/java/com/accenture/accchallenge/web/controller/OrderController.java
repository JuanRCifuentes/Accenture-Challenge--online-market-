package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.persistence.OrderRepository;
import com.accenture.accchallenge.persistence.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/all")
    public List<Order> getOrders(){
        return orderRepository.getAll();
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody List<Integer> products, @RequestParam(value = "id") int orderId){
        return orderRepository.updateOrder(products, orderId);
    }
}
