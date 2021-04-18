package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.persistence.entity.Order;
import com.accenture.accchallenge.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAll(){
        return AccChallengeApplication.world.getOrders();
    }

    public Order updateOrder(List<Integer> products, int orderId){
        Order order = getOrderById(orderId);
        List<Product> newProducts = productRepository.getProductsById(products);

        if(orderPriceIncreased(newProducts, order) && orderIsRecent(order)){
            order.setProducts(newProducts);
            order.calculateSubtotal();
            order.calculateShipping();
            order.calculateTotal();
            return order;
        } else {
            return null;
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

    public Order getOrderById(int orderId){
        List<Order> orders = getAll();
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

}
