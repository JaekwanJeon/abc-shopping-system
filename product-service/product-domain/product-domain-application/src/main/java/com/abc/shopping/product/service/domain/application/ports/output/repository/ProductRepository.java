package com.abc.shopping.product.service.domain.application.ports.output.repository;

import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.product.service.domain.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> getProduct(ProductId productId);
}
