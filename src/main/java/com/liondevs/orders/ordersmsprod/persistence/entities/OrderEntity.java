package com.liondevs.orders.ordersmsprod.persistence.entities;



import com.liondevs.orders.ordersmsprod.enums.OrderStates;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Document(collection = "orders")
@Data
public class OrderEntity {
    @Id
    private String id;
    @NotNull

    private Long restaurantId;

    @NotNull
    private Long userId;

    @NotNull
    private OrderStates state;
    @NotNull

    private double total;
    @NotNull
    private double subtotal;
    @NotNull
    private double iva;

    @NotNull
    private List<Product> products;

    @CreatedDate
    private LocalDateTime created_at;

    @CreatedDate
    private LocalDateTime updated_at;

}
