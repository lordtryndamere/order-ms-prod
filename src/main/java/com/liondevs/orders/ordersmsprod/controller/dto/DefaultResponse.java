package com.liondevs.orders.ordersmsprod.controller.dto;

import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
public class DefaultResponse {
    private String message;
    private OrderEntity order;


}
