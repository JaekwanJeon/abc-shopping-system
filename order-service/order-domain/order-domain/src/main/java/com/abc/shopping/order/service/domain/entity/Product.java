package com.abc.shopping.order.service.domain.entity;

import com.abc.shopping.domain.entity.BaseEntity;
import com.abc.shopping.domain.valueobject.Money;
import com.abc.shopping.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    private Long quantity;


    public Product(ProductId productId, String name, Money price, Long quantity) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public Product(ProductId productId) {
        super.setId(productId);
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ProductId id;
        private String name;
        private Money price;
        private Long quantity;


        public Builder id(ProductId id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(Money price) {
            this.price = price;
            return this;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            Product product = new Product(null);
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            return product;
        }
    }
}
