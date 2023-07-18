package com.liondevs.orders.ordersmsprod.service;

import com.liondevs.orders.ordersmsprod.controller.dto.DefaultResponse;
import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.enums.OrderStates;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;



public interface OrderService {
    OrderEntity create(OrderDTO order, String userId);
    ResponseEntity<DefaultResponse> update(OrderStates state, String id);

    ResponseEntity<List<OrderEntity>> getOrders(Long restaurantId, Long userId);
}
