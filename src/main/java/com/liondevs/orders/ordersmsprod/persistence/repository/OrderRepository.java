package com.liondevs.orders.ordersmsprod.persistence.repository;

import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface OrderRepository extends MongoRepository<OrderEntity,String> {



	public List<OrderEntity> findAllByUserIdAndPlaceId (Long userId, Long placeId);
}
