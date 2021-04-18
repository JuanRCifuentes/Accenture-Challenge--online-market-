package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.AccChallengeApplication;
import com.accenture.accchallenge.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/array-test")
public class ArrayTest {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String getName(){
        return AccChallengeApplication.mundo.getProductos().get(0).getNombre();
    }
}
