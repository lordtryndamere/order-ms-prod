package com.liondevs.orders.ordersmsprod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrdersMsProdApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersMsProdApplication.class, args);
    }

}
