package com.liondevs.orders.ordersmsprod.controller.dto;

import com.liondevs.orders.ordersmsprod.persistence.entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long placeId;
    private String riderId;
    private List<Product> products;
}
