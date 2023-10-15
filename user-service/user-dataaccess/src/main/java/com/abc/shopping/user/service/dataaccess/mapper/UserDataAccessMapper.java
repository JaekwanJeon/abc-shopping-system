package com.abc.shopping.user.service.dataaccess.mapper;

import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.user.service.dataaccess.entity.UserEntity;
import com.abc.shopping.user.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDataAccessMapper {

    public UserEntity userTouserEntity(User user) {
        UserEntity userEntity = UserEntity.builder()
                .id(user.getId().getValue())
                .userName(user.getUserName())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .build();
        return userEntity;
    }

    public User userEntityTouser(UserEntity userEntity) {
        return User.builder()
                .id(new UserId(userEntity.getId()))
                .userName(userEntity.getUserName())
                .phoneNumber(userEntity.getPhoneNumber())
                .address(userEntity.getAddress())
                .build();
    }

}
