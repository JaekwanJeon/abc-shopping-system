package com.abc.shopping.user.service.domain.application.mapper;

import com.abc.shopping.user.service.domain.application.dto.get.UserDto;
import com.abc.shopping.user.service.domain.application.dto.get.UserResponse;
import com.abc.shopping.user.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserDataMapper {

    public UserResponse userToUserResponse(User user) {

        return UserResponse.builder()
                .userDto(UserDto.builder()
                        .id(user.getId().getValue().toString())
                        .userName(user.getUserName())
                        .phoneNumber(user.getPhoneNumber())
                        .address(user.getAddress()).build())
                .build();
    }

}
