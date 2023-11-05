package com.abc.shopping.product.service.dataaccess.repository;

import com.abc.shopping.domain.valueobject.ProductId;
import com.abc.shopping.product.service.dataaccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {

    @Query("SELECT p FROM product as p WHERE p.id IN (:productIds)")
    List<ProductEntity> findByProductIds(@Param("productIds") List<UUID> productIds);

}

