package com.liondevs.orders.ordersmsprod.controller;

import com.liondevs.orders.ordersmsprod.controller.dto.DefaultResponse;
import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.enums.OrderStates;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderController {
    OrderEntity createOrder(OrderDTO request, String userId);

    @GetMapping("/{id}/{state}")
    abstract ResponseEntity<DefaultResponse> update(@RequestParam OrderStates state, @RequestParam String id);


}
