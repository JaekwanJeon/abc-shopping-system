package com.abc.shopping.user.service.domain.application.ports.input.service;

import com.abc.shopping.user.service.domain.application.dto.get.UserResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface UserApplicationService {
    UserResponse getUser(UUID userId);

}
