package com.liondevs.orders.ordersmsprod.controller.dto;

import com.liondevs.orders.ordersmsprod.persistence.entities.Product;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private String restaurantId;
    private List<Product> products;
}
