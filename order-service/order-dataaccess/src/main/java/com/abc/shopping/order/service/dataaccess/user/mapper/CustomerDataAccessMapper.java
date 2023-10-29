package com.abc.shopping.order.service.dataaccess.user.mapper;

import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.order.service.dataaccess.user.entity.CustomerEntity;
import com.abc.shopping.order.service.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public User customerEntityToCustomer(CustomerEntity customerEntity) {
        return new User(new UserId(customerEntity.getId()));
    }

}
