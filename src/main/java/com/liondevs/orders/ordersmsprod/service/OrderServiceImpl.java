package com.liondevs.orders.ordersmsprod.service;

import com.liondevs.orders.ordersmsprod.controller.dto.OrderDTO;
import com.liondevs.orders.ordersmsprod.exceptions.DefaultException;
import com.liondevs.orders.ordersmsprod.mappers.OrderDTOToOrderEntityMapper;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import com.liondevs.orders.ordersmsprod.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService{

    private static final  double iva = 19;
    private final OrderRepository orderRepository;
    private final OrderDTOToOrderEntityMapper mapper;

    public OrderEntity create(OrderDTO orderDTO){
        try {
            OrderEntity  order = mapper.map(orderDTO);
            log.info("saving order with id: {}",order.getOrderId());
            orderRepository.save(order);
            return  order;
        }catch (RuntimeException ex){
            throw  new DefaultException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
