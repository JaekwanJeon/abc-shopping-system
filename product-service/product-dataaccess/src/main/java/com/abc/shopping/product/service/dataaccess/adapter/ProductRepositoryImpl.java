package com.abc.shopping.product.service.dataaccess.adapter;

import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.product.service.dataaccess.mapper.ProductDataAccessMapper;
import com.abc.shopping.product.service.dataaccess.repository.ProductJpaRepository;
import com.abc.shopping.product.service.domain.application.ports.output.repository.ProductRepository;
import com.abc.shopping.product.service.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    ProductJpaRepository productJpaRepository;
    ProductDataAccessMapper productDataAccessMapper;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository, ProductDataAccessMapper productDataAccessMapper) {
        this.productJpaRepository = productJpaRepository;
        this.productDataAccessMapper = productDataAccessMapper;
    }

    @Override
    public Optional<Product> getProduct(ProductId productId) {
        return productJpaRepository.findById(productId.getValue())
                .map(productDataAccessMapper::productEntityToProduct);
    }

    @Override
    public List<Product> getProducts(List<ProductId> productIds) {
        return productJpaRepository.findByProductIds(productIds.stream().map(i->i.getValue()).toList())
                .stream().map(productDataAccessMapper::productEntityToProduct).toList();
    }
}
