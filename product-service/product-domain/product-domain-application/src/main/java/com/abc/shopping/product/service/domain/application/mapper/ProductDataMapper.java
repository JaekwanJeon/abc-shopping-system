package com.abc.shopping.product.service.domain.application.mapper;

import com.abc.shopping.product.service.domain.application.dto.get.ProductDto;
import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;
import com.abc.shopping.product.service.domain.application.dto.get.ProductsResponse;
import com.abc.shopping.product.service.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDataMapper {

    public ProductResponse productToproductResponse(Product product) {
        return ProductResponse.builder()
                .product(product)
                .build();
    }

    public ProductsResponse productsToproductsResponse(List<ProductDto> products) {
        return ProductsResponse.builder()
                .products(products)
                .build();
    }

    public ProductDto productToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId().getValue().toString())
                .name(product.getName())
                .company(product.getCompany())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }


}
