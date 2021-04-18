package com.accenture.accchallenge.persistence;

import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> getAll(){
        return AccChallengeApplication.world.getProducts();
    }

    public Product getProductById(int productId){
        List<Product> products = getAll();

        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductsById(List<Integer> pProducts){
        List <Product> products = new ArrayList<Product>();

        for (int idProduct: pProducts) {
            Product tempProduct = getProductById(idProduct);
            products.add(tempProduct);
        }
        return products;
    }

}
