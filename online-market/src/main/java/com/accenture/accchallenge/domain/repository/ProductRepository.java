package com.accenture.accchallenge.domain.repository;

import com.accenture.accchallenge.persistence.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();
    Product getProductById(int productId);
    List<Product> getProductsById(List<Integer> pProducts);

}
