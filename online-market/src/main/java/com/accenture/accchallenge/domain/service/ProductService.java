package com.accenture.accchallenge.domain.service;

import com.accenture.accchallenge.domain.repository.ProductRepository;
import com.accenture.accchallenge.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id){
        return productRepository.getProductById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAll();
    }
}
