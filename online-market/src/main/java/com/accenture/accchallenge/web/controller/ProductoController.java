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
    public int getProducto(@RequestParam(value = "nombre") String nom){
        return productoRepository.getProductoByNombre(nom).getProductoId();
    }

    @GetMapping("/all")
    public List<Producto> getProducto(){
        return productoRepository.getAll();
    }
}
