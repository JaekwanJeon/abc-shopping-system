package com.abc.shopping.order.service.domain.application.ports.output.repository;

import com.abc.shopping.domain.valueobject.OrderId;
import com.abc.shopping.order.service.domain.entity.Order;
import com.abc.shopping.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
