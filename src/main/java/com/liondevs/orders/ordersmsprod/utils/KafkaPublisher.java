package com.liondevs.orders.ordersmsprod.utils;


import com.liondevs.orders.ordersmsprod.event.Event;
import com.liondevs.orders.ordersmsprod.event.EventType;
import com.liondevs.orders.ordersmsprod.event.OrderCreatedEvent;
import com.liondevs.orders.ordersmsprod.persistence.entities.OrderEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;




@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaPublisher {

    private  final KafkaTemplate<String, Event<?>> producer;




    public void publish(OrderEntity order) {

        OrderCreatedEvent created = new OrderCreatedEvent();
        created.setData(order);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(LocalDateTime.now());
        created.setFrom("fast-food-app-orders");

        String topicNotifications = "orders-ms-notification";
        producer.send(topicNotifications, created);
    }

}
