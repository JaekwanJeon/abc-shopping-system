package com.abc.shopping.product.service.domain.application.ports.input.service;

import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;

import java.util.UUID;

public interface ProductApplicationService {
    ProductResponse getProduct(UUID userId);

}
