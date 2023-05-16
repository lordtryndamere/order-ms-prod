package com.liondevs.orders.ordersmsprod.controller;

import com.liondevs.orders.ordersmsprod.controller.dto.DefaultResponse;
import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.enums.OrderStates;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import com.liondevs.orders.ordersmsprod.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;

    @PostMapping("/")
    public OrderEntity createOrder(@RequestBody OrderDTO request, @RequestHeader(name = "X-Auth-User-id") String userId) {
        log.info("request order received: {}",request);
        return orderService.create(request, userId);
    }

    @Override
    @GetMapping("/update")
    public ResponseEntity<DefaultResponse> update(@RequestParam OrderStates state, @RequestParam  String id) {
        return orderService.update(state,id);
    }
}
