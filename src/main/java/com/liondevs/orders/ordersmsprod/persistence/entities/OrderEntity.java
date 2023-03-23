package com.liondevs.orders.ordersmsprod.persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String restaurantId;
    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double subtotal;

    @Column(nullable = false)
    private double iva;

    @Column( nullable = false)
    private List<Product> products;

    @CreatedDate
    private LocalDateTime created_at;

    @CreatedDate
    private LocalDateTime updated_at;




}
