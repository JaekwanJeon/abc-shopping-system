package com.abc.shopping.product.service.domain.application.command;

import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;
import com.abc.shopping.product.service.domain.application.mapper.ProductDataMapper;
import com.abc.shopping.product.service.domain.application.ports.output.repository.ProductRepository;
import com.abc.shopping.product.service.domain.entity.Product;
import com.abc.shopping.product.service.domain.exeception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class GetProductCommandHandler {

    // private final  orderDataMapper;

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
}
