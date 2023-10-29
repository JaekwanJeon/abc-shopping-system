package com.abc.shopping.order.service.dataaccess.user.repository;

import com.abc.shopping.order.service.dataaccess.user.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
}
