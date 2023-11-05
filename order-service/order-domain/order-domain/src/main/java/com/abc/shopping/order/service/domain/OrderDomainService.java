package com.abc.shopping.order.service.domain;

import com.abc.shopping.order.service.domain.entity.Delivery;
import com.abc.shopping.order.service.domain.entity.Order;
import com.abc.shopping.order.service.domain.entity.Product;
import com.abc.shopping.order.service.domain.event.OrderCancelledEvent;
import com.abc.shopping.order.service.domain.event.OrderCreatedEvent;
import com.abc.shopping.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, List<Product> productList);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
