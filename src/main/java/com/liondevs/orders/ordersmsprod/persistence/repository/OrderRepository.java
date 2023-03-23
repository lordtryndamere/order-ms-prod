package com.liondevs.orders.ordersmsprod.persistence.repository;

import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
