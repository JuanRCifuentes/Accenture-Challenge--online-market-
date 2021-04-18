package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.domain.repository.OrderRepository;
import com.accenture.accchallenge.persistence.entity.Order;
import com.accenture.accchallenge.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class OrderRepo implements OrderRepository {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Order> getAllOrders(){
        return AccChallengeApplication.world.getOrders();
    }

    @Override
    public Optional<Order> updateOrder(List<Integer> products, int orderId){
        Order order = null;

        if(Objects.isNull(getOrderById(orderId))){
            return Optional.ofNullable(order);
        } else {
            order = getOrderById(orderId);
        }

        List<Product> newProducts = productRepo.getProductsById(products);

        if(orderPriceIncreased(newProducts, order) && orderIsRecent(order)){
            order.setProducts(newProducts);
            order.calculateSubtotal();
            order.calculateShipping();
            order.calculateTotal();
            return Optional.of(order);
        } else {
            return Optional.of(order);
        }
    }

    public Boolean orderIsRecent(Order order){
        long hours = ChronoUnit.HOURS.between(order.getCreationDate(), LocalDateTime.now());
        return hours < 5;
    }

    public Boolean orderPriceIncreased(List<Product> newProducts, Order order){
        Order newOrder = new Order(1, newProducts, LocalDateTime.now());
        Boolean priceIncreased = newOrder.getSubtotal().compareTo(order.getSubtotal())==1 ||
                newOrder.getSubtotal().compareTo(order.getSubtotal())==0;

        return priceIncreased;
    }

    @Override
    public Order getOrderById(int orderId){
        List<Order> orders = getAllOrders();
        Order order = null;
        for (Order orderTemp : orders) {
            if (orderTemp.getOrderId() == orderId) {
                order = orderTemp;
            }
        }
        return order;
    }

}
