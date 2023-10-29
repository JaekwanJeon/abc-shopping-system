package com.abc.shopping.order.service.domain.application;

import com.abc.shopping.order.service.domain.application.command.OrderCreateCommandHandler;
import com.abc.shopping.order.service.domain.application.command.OrderTrackCommandHandler;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderCommand;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderResponse;
import com.abc.shopping.order.service.domain.application.dto.track.TrackOrderQuery;
import com.abc.shopping.order.service.domain.application.dto.track.TrackOrderResponse;
import com.abc.shopping.order.service.domain.application.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Slf4j
@Validated
@Service
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;

    private final OrderTrackCommandHandler orderTrackCommandHandler;

    public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler,
                                       OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public Mono<CreateOrderResponse> createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }
}
