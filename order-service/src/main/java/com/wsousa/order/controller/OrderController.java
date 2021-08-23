package com.wsousa.order.controller;

import com.wsousa.dto.OrderRequestDTO;
import com.wsousa.dto.OrderResponseDTO;
import com.wsousa.order.entity.PurchaseOrder;
import com.wsousa.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDTO requestDTO){
        requestDTO.setOrderId(UUID.randomUUID());
        return this.service.createOrder(requestDTO);
    }

    @GetMapping("/all")
    public List<OrderResponseDTO> getOrders(){
        return this.service.getAll();
    }

}
