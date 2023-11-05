package com.abc.shopping.order.service.domain.application.ports.output.repository;


import com.abc.shopping.order.service.domain.application.dto.create.ProductDto;
import com.abc.shopping.order.service.domain.application.dto.create.UserDto;
import com.abc.shopping.order.service.domain.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface ProductReactiveClient {

    Flux<ProductDto> findProducts(List<UUID> productIds);

}
