package com.abc.shopping.order.service.domain.valueobject;


import com.abc.shopping.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
