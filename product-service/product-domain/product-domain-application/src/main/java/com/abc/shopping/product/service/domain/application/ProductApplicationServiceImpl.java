package com.abc.shopping.product.service.domain.application;

import com.abc.shopping.product.service.domain.application.command.GetProductCommandHandler;
import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;
import com.abc.shopping.product.service.domain.application.dto.get.ProductsResponse;
import com.abc.shopping.product.service.domain.application.ports.input.service.ProductApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@Service
class ProductApplicationServiceImpl implements ProductApplicationService {

    GetProductCommandHandler getProductCommandHandler;

    public ProductApplicationServiceImpl(GetProductCommandHandler getProductCommandHandler) {
        this.getProductCommandHandler = getProductCommandHandler;
    }

    @Override
    public ProductResponse getProduct(UUID productId) {
        return getProductCommandHandler.getProduct(productId);
    }

    @Override
    public ProductsResponse getProducts(List<UUID> productIds) {
        return getProductCommandHandler.getProducts(productIds);
    }

}
