package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.persistence.Mundo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/array-test")
public class ArrayTest {

    Mundo mundo;

    @GetMapping
    public String getName(){
        mundo = new Mundo();
        return mundo.getProducto().getNombre();
    }
}
