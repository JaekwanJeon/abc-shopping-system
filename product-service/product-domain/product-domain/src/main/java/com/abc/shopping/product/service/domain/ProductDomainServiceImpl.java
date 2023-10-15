package com.abc.shopping.product.service.domain;

import com.abc.shopping.user.service.domain.ProductDomainService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDomainServiceImpl implements ProductDomainService {

//    @Override
//    public OrderCreatedEvent validateAndInitiateOrder(Order order, Delivery delivery) {
//        validateDelivery(delivery);
//        setOrderProductInformation(order, delivery);
//        order.validateOrder();
//        order.initializeOrder();
//        log.info("Order with id: {} is initiated", order.getId().getValue());
//        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
//    }
//
//    @Override
//    public OrderPaidEvent payOrder(Order order) {
//        order.pay();
//        log.info("Order with id: {} is paid", order.getId().getValue());
//        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
//    }
//
//    @Override
//    public void approveOrder(Order order) {
//        order.approve();
//        log.info("Order with id: {} is approved", order.getId().getValue());
//    }
//
//    @Override
//    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
//        order.initCancel(failureMessages);
//        log.info("Order payment is cancelling for order id: {}", order.getId().getValue());
//        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
//    }
//
//    @Override
//    public void cancelOrder(Order order, List<String> failureMessages) {
//        order.cancel(failureMessages);
//        log.info("Order with id: {} is cancelled", order.getId().getValue());
//    }
//
//    private void validateDelivery(Delivery delivery) {
//        if (!delivery.isActive()) {
//            throw new OrderDomainException("delivery with id " + delivery.getId().getValue() +
//                    " is currently not active!");
//        }
//    }
//
//    private void setOrderProductInformation(Order order, Delivery delivery) {
//        order.getItems().forEach(orderItem -> delivery.getProducts().forEach(product -> {
//            Product currentProduct = orderItem.getProduct();
//            if (currentProduct.equals(product)) {
//                currentProduct.updateWithConfirmedNameAndPrice(product.getName(),
//                        product.getPrice());
//            }
//        }));
//    }
}
