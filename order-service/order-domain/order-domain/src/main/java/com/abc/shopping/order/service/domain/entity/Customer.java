package com.abc.shopping.order.service.domain.entity;


import com.abc.shopping.domain.entity.AggregateRoot;
import com.abc.shopping.domain.valueobject.UserId;

public class Customer extends AggregateRoot<UserId> {
    public Customer() {
    }

    public Customer(UserId userId) {
        super.setId(userId);
    }

}
