package com.liondevs.orders.ordersmsprod.service;

import com.liondevs.orders.ordersmsprod.controller.dto.DefaultResponse;
import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.enums.OrderStates;
import com.liondevs.orders.ordersmsprod.exceptions.DefaultException;
import com.liondevs.orders.ordersmsprod.exceptions.NotFoundException;
import com.liondevs.orders.ordersmsprod.mappers.OrderDTOToOrderEntityMapper;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import com.liondevs.orders.ordersmsprod.persistence.repository.OrderRepository;
import com.liondevs.orders.ordersmsprod.utils.KafkaPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService{

    private static final  double iva = 19;

     private final OrderRepository orderRepository;
    private final OrderDTOToOrderEntityMapper mapper;
    private final KafkaPublisher publisher;

    public OrderEntity create(OrderDTO orderDTO, String userId){
        try {
            OrderEntity  order = mapper.map(orderDTO);
            order.setUserId(Long.parseLong(userId));
            log.info("saving order with id: {}",order.getId());
            orderRepository.insert(order);
            publisher.publish(order);
            return  order;
        }catch (RuntimeException ex){
            throw  new DefaultException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<DefaultResponse> update(OrderStates state, String id) {

        try {
            String message = "Order updated successfully";
            OrderEntity order =  orderRepository.findById(id).orElseThrow(()->new NotFoundException("Order not found",HttpStatus.NOT_FOUND));
            order.setState(state);
            order =    orderRepository.save(order);
            DefaultResponse response = DefaultResponse.builder().message(message).order(order).build();
            return  ResponseEntity.ok(response);

        }catch (RuntimeException ex ){
            throw  new DefaultException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
