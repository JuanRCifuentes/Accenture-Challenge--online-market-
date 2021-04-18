package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.persistence.ProductoRepository;
import com.accenture.accchallenge.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public Producto getProductoById(@RequestParam(value = "id") int id){
        return productoRepository.getProductoById(id);
    }

    @GetMapping("/all")
    public List<Producto> getAllProducts(){
        return productoRepository.getAll();
    }
}