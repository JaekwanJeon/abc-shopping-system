package com.abc.shopping.order.service.domain.application.ports.output.repository;


import com.abc.shopping.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);

}
