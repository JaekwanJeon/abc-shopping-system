package com.abc.shopping.order.service.application.controller;

import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderCommand;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderResponse;
import com.abc.shopping.order.service.domain.application.dto.track.TrackOrderQuery;
import com.abc.shopping.order.service.domain.application.dto.track.TrackOrderResponse;
import com.abc.shopping.order.service.domain.application.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/vnd.api.v1+json")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public Mono<ResponseEntity<CreateOrderResponse>> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        log.info("Creating order for customer: {} at restaurant: {}", createOrderCommand.getUserId(),
                createOrderCommand.getRestaurantId());
        return orderApplicationService.createOrder(createOrderCommand).map(ResponseEntity::ok)
                .onErrorReturn(WebClientResponseException.class, ResponseEntity.badRequest().build())
                .onErrorReturn(WebClientRequestException.class, ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build());
//        log.info("Order created with tracking id: {}", createOrderResponse.getOrderTrackingId());
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<TrackOrderResponse> getOrderByTrackingId(@PathVariable UUID trackingId) {
       TrackOrderResponse trackOrderResponse =
               orderApplicationService.trackOrder(TrackOrderQuery.builder().orderTrackingId(trackingId).build());
       log.info("Returning order status with tracking id: {}", trackOrderResponse.getOrderTrackingId());
       return  ResponseEntity.ok(trackOrderResponse);
    }
}
