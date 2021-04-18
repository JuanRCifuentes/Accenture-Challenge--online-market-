package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.domain.service.OrderService;
import com.accenture.accchallenge.persistence.entity.Order;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Get all Orders")
    @ApiResponse(code=200, message="OK")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    @ApiOperation("Updates an order with an ID and a productID array")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Order not Found")
    })
    public ResponseEntity<Order> updateOrder(@RequestBody List<Integer> products, @ApiParam(value = "The id of the order", required = true, example = "0") @RequestParam(value = "id") int orderId){
        Order tempOrder = orderService.getOrderById(orderId);
        Order order = orderService.updateOrder(products, orderId).map(tempO -> tempO).orElse(null);
        if (Objects.isNull(order)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (order.equals(tempOrder)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
