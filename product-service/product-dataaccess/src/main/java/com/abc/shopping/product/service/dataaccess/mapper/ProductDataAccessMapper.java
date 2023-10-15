package com.abc.shopping.product.service.dataaccess.mapper;

import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.product.service.dataaccess.entity.ProductEntity;
import com.abc.shopping.product.service.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDataAccessMapper {

    public ProductEntity productToProductEntity(Product product) {

        return ProductEntity.builder()
                .id(product.getId().getValue())
                .name(product.getName())
                .company(product.getCompany())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .build();

    }

    public Product productEntityToProduct(ProductEntity productEntity) {
        return Product.builder()
                .productId(new ProductId(productEntity.getId()))
                .name(productEntity.getName())
                .company(productEntity.getCompany())
                .description(productEntity.getDescription())
                .quantity(productEntity.getQuantity())
                .build();
    }

}
