package com.abc.shopping.order.service.domain.application.ports.input.service;

import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderCommand;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderResponse;
import com.abc.shopping.order.service.domain.application.dto.track.TrackOrderQuery;
import com.abc.shopping.order.service.domain.application.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface OrderApplicationService {

    Mono<CreateOrderResponse> createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
