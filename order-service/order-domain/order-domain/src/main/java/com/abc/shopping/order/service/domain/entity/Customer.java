package com.abc.shopping.order.service.domain.entity;


import com.abc.shopping.domain.entity.AggregateRoot;
import com.abc.shopping.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }

}
