package com.abc.shopping.domain.valueobject;

import java.util.UUID;

public class DeliveryId extends BaseId<UUID> {
    public DeliveryId(UUID value) {
        super(value);
    }
}
