package com.abc.shopping.product.service.domain.exeception;


import com.abc.shopping.domain.exception.DomainException;

public class ProductNotFoundException extends DomainException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
