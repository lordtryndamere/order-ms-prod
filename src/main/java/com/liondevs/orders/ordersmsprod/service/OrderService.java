package com.liondevs.orders.ordersmsprod.service;

import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;

public interface OrderService {
    OrderEntity create(OrderDTO order);
}
