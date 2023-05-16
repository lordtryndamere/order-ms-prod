package com.liondevs.orders.ordersmsprod.persistence.entities;



import lombok.*;





@Data
public class Product {

    private Long id;
    private String name;
    private String desc;

    private double price;

    private double iva;

    private int quantity;
}
