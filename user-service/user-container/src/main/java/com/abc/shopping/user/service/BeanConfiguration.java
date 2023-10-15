package com.abc.shopping.user.service;

import com.abc.shopping.user.service.domain.UserDomainService;
import com.abc.shopping.user.service.domain.UserDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserDomainService orderDomainService() {
        return new UserDomainServiceImpl();
    }
}
