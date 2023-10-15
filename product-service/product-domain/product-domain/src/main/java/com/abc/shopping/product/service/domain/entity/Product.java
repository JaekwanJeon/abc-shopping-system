package com.abc.shopping.product.service.domain.entity;


import com.abc.shopping.domain.entity.AggregateRoot;
import com.abc.shopping.domain.valueobject.ProductId;

public class Product extends AggregateRoot<ProductId> {

    private String name;
    private String company;
    private String description;

    private Long quantity;

    public Product(Builder builder) {
        setId(builder.productId);
        name = builder.name;
        company = builder.company;
        description = builder.description;
        quantity = builder.quantity;


    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    public static final class Builder {

        private ProductId productId;
        private String name;
        private String company;
        private String description;
        private Long quantity;

        public Builder productId(ProductId val) {
            productId = val;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
