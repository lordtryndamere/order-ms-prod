package com.liondevs.orders.ordersmsprod.controller;

import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;

public interface OrderController {
    OrderEntity createOrder(OrderDTO request);


}
