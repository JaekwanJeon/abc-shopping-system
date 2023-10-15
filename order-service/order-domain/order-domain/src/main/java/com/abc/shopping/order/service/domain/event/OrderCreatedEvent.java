package com.abc.shopping.order.service.domain.event;

import com.abc.shopping.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCreatedEvent extends OrderEvent {
    public OrderCreatedEvent(Order order,
                             ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
