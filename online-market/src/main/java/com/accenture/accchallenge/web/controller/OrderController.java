package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.domain.service.OrderService;
import com.accenture.accchallenge.persistence.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody List<Integer> products, @RequestParam(value = "id") int orderId){
        Order order = orderService.updateOrder(products, orderId).map(tempOrder -> tempOrder).orElse(null);
        Order tempOrder = orderService.getOrderById(orderId);
        if (Objects.isNull(order)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (order.equals(tempOrder)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
