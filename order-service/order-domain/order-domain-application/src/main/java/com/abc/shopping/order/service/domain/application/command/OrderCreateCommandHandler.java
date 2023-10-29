package com.abc.shopping.order.service.domain.application.command;

import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderCommand;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderResponse;
import com.abc.shopping.order.service.domain.application.mapper.OrderDataMapper;
import com.abc.shopping.order.service.domain.application.service.OrderCreateHelper;
import com.abc.shopping.order.service.domain.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;
//    private final PaymentOutboxHelper paymentOutboxHelper;
//    private final OrderSagaHelper orderSagaHelper;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper,
                                     OrderDataMapper orderDataMapper)
//                                     PaymentOutboxHelper paymentOutboxHelper,
//                                     OrderSagaHelper orderSagaHelper) {
    {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
//        this.paymentOutboxHelper = paymentOutboxHelper;
//        this.orderSagaHelper = orderSagaHelper;
    }

    @Transactional
    public Mono<CreateOrderResponse> createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateHelper.persistOrder(createOrderCommand).log()
                .map(event->orderDataMapper.orderToCreateOrderResponse(
                    event.getOrder(), "Order created successfully")
        );
//        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
//        CreateOrderResponse createOrderResponse = orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder(),
//                "Order created successfully");

//        paymentOutboxHelper.savePaymentOutboxMessage(orderDataMapper
//                .orderCreatedEventToOrderPaymentEventPayload(orderCreatedEvent),
//                orderCreatedEvent.getOrder().getOrderStatus(),
//                orderSagaHelper.orderStatusToSagaStatus(orderCreatedEvent.getOrder().getOrderStatus()),
//                OutboxStatus.STARTED,
//                UUID.randomUUID());

//        log.info("Returning CreateOrderResponse with order id: {}", orderCreatedEvent.getOrder().getId());
//
//        return createOrderResponse;
    }
}
