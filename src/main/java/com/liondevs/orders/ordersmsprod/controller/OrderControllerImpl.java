package com.liondevs.orders.ordersmsprod.controller;

import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import com.liondevs.orders.ordersmsprod.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;

    @PostMapping("/")
    public OrderEntity createOrder(@RequestBody OrderDTO request) {
        log.info("request order received: {}",request);
        return orderService.create(request);
    }
}
