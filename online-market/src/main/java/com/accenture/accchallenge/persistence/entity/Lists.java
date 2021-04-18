package com.accenture.accchallenge.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lists {

    private List<Product> productsList = new ArrayList<Product>();
    private List<Order> ordersList = new ArrayList<Order>();

    public Lists(){
        createProducts();
        createOrders();
    }

    public void createProducts(){
        productsList.add(new Product(0, "Hamburguesa", 20000));
        productsList.add(new Product(1, "Pizza", 50000));
        productsList.add(new Product(2, "Pasta", 25000));
        productsList.add(new Product(3, "Poke", 35000));
        productsList.add(new Product(4, "Sushi", 25000));
    }

    public void createOrders(){

        Random rand = new Random();
        int numberOfOrders = rand.nextInt(5)+ 5;

        List<Product> tempList = Arrays.asList(productsList.get(0), productsList.get(1));
        ordersList.add(new Order(0, tempList, LocalDateTime.now()));

        for(int i = 1; i<numberOfOrders; i++){

            int numberOfProducts = rand.nextInt(4) + 1;

            tempList = new ArrayList<Product>();
            for (int j=0; j<numberOfProducts; j++){
                int productIndex = rand.nextInt(productsList.size());
                tempList.add(productsList.get(productIndex));
            }
            ordersList.add(new Order(i, tempList, LocalDateTime.now().minusHours(i)));
        }

    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

}
