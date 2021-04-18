package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.persistence.PedidoRepository;
import com.accenture.accchallenge.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/all")
    public List<Pedido> getProducto(){
        return pedidoRepository.getAll();
    }

}
