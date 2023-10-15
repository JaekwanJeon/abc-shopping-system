package com.abc.shopping.order.service.domain.entity;

import com.abc.shopping.domain.entity.AggregateRoot;
import com.abc.shopping.domain.valueobject.DeliveryId;

import java.util.List;

public class Delivery extends AggregateRoot<DeliveryId> {
    private final List<Product> products;
    private boolean active;

    private Delivery(Builder builder) {
        super.setId(builder.deliveryId);
        products = builder.products;
        active = builder.active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }

    public static final class Builder {
        private DeliveryId deliveryId;
        private List<Product> products;
        private boolean active;

        private Builder() {
        }

        public Builder deliveryId(DeliveryId val) {
            deliveryId = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Delivery build() {
            return new Delivery(this);
        }
    }
}
