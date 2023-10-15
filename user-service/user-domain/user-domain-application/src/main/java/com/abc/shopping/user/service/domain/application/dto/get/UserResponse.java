package com.abc.shopping.user.service.domain.application.dto.get;

import com.abc.shopping.user.service.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserResponse {
    private final User user;
    private final List<String> failureMessages;
}
