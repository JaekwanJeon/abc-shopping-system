package com.abc.shopping.order.service.domain.entity;


import com.abc.shopping.domain.entity.AggregateRoot;
import com.abc.shopping.domain.valueobject.UserId;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User extends AggregateRoot<UserId> {

    public User(UserId userId) {
        setId(userId);
    }

    private String userName;
    private String phoneNumber;
    private String address;


}
