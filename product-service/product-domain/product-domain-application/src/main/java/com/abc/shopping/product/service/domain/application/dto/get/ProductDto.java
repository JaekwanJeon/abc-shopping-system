package com.abc.shopping.product.service.domain.application.dto.get;

import com.abc.shopping.domain.valueobject.ProductId;

public class ProductDto {

    private String id;
    private String name;
    private String company;
    private String description;

    private Long quantity;

    private Long price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private String company;
        private String description;
        private Long quantity;
        private Long price;

        public Builder id(String id) {
            this.id = id;
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

        public Builder price(Long price) {
            this.price = price;
            return this;
        }

        public ProductDto build() {
            ProductDto productDto = new ProductDto();
            productDto.setId(id);
            productDto.setName(name);
            productDto.setCompany(company);
            productDto.setDescription(description);
            productDto.setQuantity(quantity);
            productDto.setPrice(price);
            return productDto;
        }
    }
}
