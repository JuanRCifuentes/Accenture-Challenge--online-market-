package com.accenture.accchallenge.domain.repository;

import com.accenture.accchallenge.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();
}
