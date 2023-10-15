package com.abc.shopping.order.service.domain.application.mapper;

import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.domain.valueobject.DeliveryId;
import com.abc.shopping.domain.valueobject.Money;
import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderCommand;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderResponse;
import com.abc.shopping.order.service.domain.application.dto.create.OrderAddress;
import com.abc.shopping.order.service.domain.application.dto.create.OrderItem;
import com.abc.shopping.order.service.domain.application.dto.track.TrackOrderResponse;
import com.abc.shopping.order.service.domain.entity.Delivery;
import com.abc.shopping.order.service.domain.entity.Order;
import com.abc.shopping.order.service.domain.entity.OrderItemDomain;
import com.abc.shopping.order.service.domain.entity.Product;
import com.abc.shopping.order.service.domain.valueobject.StreetAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Delivery createOrderCommandToDelivery(CreateOrderCommand createOrderCommand) {
        return Delivery.builder()
                .deliveryId(new DeliveryId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                                new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }
    
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new UserId(createOrderCommand.getCustomerId()))
                .deliveryId(new DeliveryId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order) {
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }

//    public OrderPaymentEventPayload orderCreatedEventToOrderPaymentEventPayload(OrderCreatedEvent orderCreatedEvent) {
//        return OrderPaymentEventPayload.builder()
//                .customerId(orderCreatedEvent.getOrder().getCustomerId().getValue().toString())
//                .orderId(orderCreatedEvent.getOrder().getId().getValue().toString())
//                .price(orderCreatedEvent.getOrder().getPrice().getAmount())
//                .createdAt(orderCreatedEvent.getCreatedAt())
//                .paymentOrderStatus(PaymentOrderStatus.PENDING.name())
//                .build();
//    }
//
//    public OrderPaymentEventPayload orderCancelledEventToOrderPaymentEventPayload(OrderCancelledEvent
//                                                                                          orderCancelledEvent) {
//        return OrderPaymentEventPayload.builder()
//                .customerId(orderCancelledEvent.getOrder().getCustomerId().getValue().toString())
//                .orderId(orderCancelledEvent.getOrder().getId().getValue().toString())
//                .price(orderCancelledEvent.getOrder().getPrice().getAmount())
//                .createdAt(orderCancelledEvent.getCreatedAt())
//                .paymentOrderStatus(PaymentOrderStatus.CANCELLED.name())
//                .build();
//    }
//
//    public OrderApprovalEventPayload orderPaidEventToOrderApprovalEventPayload(OrderPaidEvent orderPaidEvent) {
//        return OrderApprovalEventPayload.builder()
//                .orderId(orderPaidEvent.getOrder().getId().getValue().toString())
//                .restaurantId(orderPaidEvent.getOrder().getRestaurantId().getValue().toString())
//                .restaurantOrderStatus(RestaurantOrderStatus.PAID.name())
//                .products(orderPaidEvent.getOrder().getItems().stream().map(orderItem ->
//                        OrderApprovalEventProduct.builder()
//                                .id(orderItem.getProduct().getId().getValue().toString())
//                                .quantity(orderItem.getQuantity())
//                                .build()).collect(Collectors.toList()))
//                .price(orderPaidEvent.getOrder().getPrice().getAmount())
//                .createdAt(orderPaidEvent.getCreatedAt())
//                .build();
//    }


    private List<OrderItemDomain> orderItemsToOrderItemEntities(
            List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItemDomain.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }
}
