package com.abc.shopping.product.service.domain.application.ports.input.service;

import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;
import com.abc.shopping.product.service.domain.application.dto.get.ProductsResponse;

import java.util.List;
import java.util.UUID;

public interface ProductApplicationService {
    ProductResponse getProduct(UUID userId);
    ProductsResponse getProducts(List<UUID> userId);

}
