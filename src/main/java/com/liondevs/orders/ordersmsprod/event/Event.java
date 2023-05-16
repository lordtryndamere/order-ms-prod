package com.liondevs.orders.ordersmsprod.event;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
public class Event <T> {
    private String id;
    private LocalDateTime date;

    private String from;
    private EventType type;
    private T data;
}
