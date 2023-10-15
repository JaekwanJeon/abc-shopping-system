package com.abc.shopping.user.service.domain.application;

import com.abc.shopping.user.service.domain.application.command.GetUserCommandHandler;
import com.abc.shopping.user.service.domain.application.dto.get.UserResponse;
import com.abc.shopping.user.service.domain.application.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Slf4j
@Validated
@Service
class UserApplicationServiceImpl implements UserApplicationService {

    GetUserCommandHandler getUserCommandHandler;

    public UserApplicationServiceImpl(GetUserCommandHandler getUserCommandHandler) {
        this.getUserCommandHandler = getUserCommandHandler;
    }

    @Override
    public UserResponse getUser(UUID userId) {
        return getUserCommandHandler.getUser(userId);
    }

}
