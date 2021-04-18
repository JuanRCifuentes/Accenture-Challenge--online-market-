package com.accenture.accchallenge.web.controller;

import com.accenture.accchallenge.persistence.PedidoRepository;
import com.accenture.accchallenge.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/all")
    public List<Pedido> getPedidos(){
        return pedidoRepository.getAll();
    }

    @PutMapping("/put")
    public Pedido changePedido(@RequestBody List<Integer> productos, @RequestParam(value = "id") int pedidoId){
        return pedidoRepository.actualizarPedido(productos, pedidoId);
    }

}
