package com.abc.shopping.product.service.domain.application.dto.get;

import com.abc.shopping.product.service.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ProductsResponse {
    private final List<ProductDto> products;
    private final List<String> failureMessages;
}
