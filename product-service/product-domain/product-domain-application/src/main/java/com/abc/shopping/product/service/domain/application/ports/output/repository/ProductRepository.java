package com.abc.shopping.product.service.domain.application.ports.output.repository;

import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.product.service.domain.application.dto.get.ProductsResponse;
import com.abc.shopping.product.service.domain.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Optional<Product> getProduct(ProductId productId);

    List<Product> getProducts(List<ProductId> productIds);



}
