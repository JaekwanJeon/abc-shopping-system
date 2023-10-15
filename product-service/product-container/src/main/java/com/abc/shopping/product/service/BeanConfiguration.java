package com.abc.shopping.product.service;

import com.abc.shopping.product.service.domain.ProductDomainServiceImpl;
import com.abc.shopping.user.service.domain.ProductDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductDomainService orderDomainService() {
        return new ProductDomainServiceImpl();
    }
}
