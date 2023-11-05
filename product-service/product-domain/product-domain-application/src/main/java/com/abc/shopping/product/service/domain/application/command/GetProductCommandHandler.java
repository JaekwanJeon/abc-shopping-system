package com.abc.shopping.product.service.domain.application.command;

import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.product.service.domain.application.dto.get.ProductDto;
import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;
import com.abc.shopping.product.service.domain.application.dto.get.ProductsResponse;
import com.abc.shopping.product.service.domain.application.mapper.ProductDataMapper;
import com.abc.shopping.product.service.domain.application.ports.output.repository.ProductRepository;
import com.abc.shopping.product.service.domain.entity.Product;
import com.abc.shopping.product.service.domain.exeception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class GetProductCommandHandler {

    private final ProductRepository productRepository;
    private final ProductDataMapper productDataMapper;

    public GetProductCommandHandler(ProductRepository productRepository, ProductDataMapper productDataMapper) {
        this.productRepository = productRepository;
        this.productDataMapper = productDataMapper;
    }

    @Transactional(readOnly = true)
    public ProductResponse getProduct(UUID productId) {
        Optional<Product> product = productRepository.getProduct(new ProductId(productId));
           if (product.isEmpty()) {
               log.warn("Could not find product with id: {}", productId);
               throw new ProductNotFoundException("Could not find product with id: " +
                       productId);
           }
           return productDataMapper.productToproductResponse(product.get());
    }



    public ProductsResponse getProducts(List<UUID> productUUIDs) {

        List<ProductId> productIds = productUUIDs.stream().map(ProductId::new).toList();
        List<ProductDto> products = productRepository.getProducts(productIds).stream().map(productDataMapper::productToProductDto).toList();

        if (products.isEmpty()) {
            log.warn("Could not find product with id: {}", productUUIDs);
            throw new ProductNotFoundException("Could not find product with id: " +
                    productUUIDs);
        }

        return productDataMapper.productsToproductsResponse(products);
    }
}
