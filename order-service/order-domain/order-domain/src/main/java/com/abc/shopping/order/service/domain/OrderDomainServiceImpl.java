package com.abc.shopping.order.service.domain;

import com.abc.shopping.order.service.domain.entity.Delivery;
import com.abc.shopping.order.service.domain.entity.Order;
import com.abc.shopping.order.service.domain.entity.Product;
import com.abc.shopping.order.service.domain.event.OrderCancelledEvent;
import com.abc.shopping.order.service.domain.event.OrderCreatedEvent;
import com.abc.shopping.order.service.domain.event.OrderPaidEvent;
import com.abc.shopping.order.service.domain.exception.OrderDomainException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static com.abc.shopping.domain.constants.Common.UTC;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {

    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, List<Product> productList) {
        //validateDelivery(delivery);

        log.info("OrderDomainServiceImpl : validateAndInitiateOrder");
        setOrderProductInformation(order, productList);
        order.validateOrder();
        order.initializeOrder();
        log.info("Order with id: {} is initiated", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id: {} is paid", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id: {} is approved", order.getId().getValue());
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id: {}", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with id: {} is cancelled", order.getId().getValue());
    }

    private void validateDelivery(Delivery delivery) {
        if (!delivery.isActive()) {
            throw new OrderDomainException("delivery with id " + delivery.getId().getValue() +
                    " is currently not active!");
        }
    }

    private void setOrderProductInformation(Order order, List<Product> productList) {
        order.getItems().forEach(orderItem -> productList.forEach(product -> {
            Product currentProduct = orderItem.getProduct();
            if (currentProduct.equals(product)) {
                currentProduct.updateWithConfirmedNameAndPrice(product.getName(),
                        product.getPrice());
            }
        }));
    }
}
