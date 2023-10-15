package com.abc.shopping.order.service.domain.valueobject;

import com.abc.shopping.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
