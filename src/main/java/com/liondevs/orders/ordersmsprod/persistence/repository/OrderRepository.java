package com.liondevs.orders.ordersmsprod.persistence.repository;

import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderRepository extends MongoRepository<OrderEntity,String> {

}
