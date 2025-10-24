package com.eurekaexercise.order.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaexercise.order.dto.OrderDTO;
import com.eurekaexercise.order.dto.OrderDTOFromFE;
import com.eurekaexercise.order.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO orderSaveInDB = orderService.saveOrderInDB(orderDetails);
        return new ResponseEntity<>(orderSaveInDB, HttpStatus.CREATED);
    }

    
}
