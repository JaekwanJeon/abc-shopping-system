package com.abc.shopping.order.service.dataaccess.customer.mapper;

import com.abc.shopping.domain.valueobject.CustomerId;
import com.abc.shopping.order.service.dataaccess.customer.entity.CustomerEntity;
import com.abc.shopping.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }

}
