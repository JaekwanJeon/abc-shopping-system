package com.abc.shopping.product.service.domain.application.mapper;

import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;
import com.abc.shopping.product.service.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDataMapper {

    public ProductResponse productToproductResponse(Product product) {
        return ProductResponse.builder()
                .product(product)
                .build();
    }

}
