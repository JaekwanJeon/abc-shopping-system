package com.abc.shopping.order.service.dataaccess.client.response;

import com.abc.shopping.order.service.domain.application.dto.create.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    public UserDto userDto;
    public List<String> failureMessages;

    public UserResponse() {
    }
}


