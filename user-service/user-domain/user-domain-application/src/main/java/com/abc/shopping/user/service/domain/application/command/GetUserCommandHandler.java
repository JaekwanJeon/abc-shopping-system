package com.abc.shopping.user.service.domain.application.command;

import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.user.service.domain.application.dto.get.UserResponse;
import com.abc.shopping.user.service.domain.application.mapper.UserDataMapper;
import com.abc.shopping.user.service.domain.application.ports.output.repository.UserRepository;
import com.abc.shopping.user.service.domain.entity.User;
import com.abc.shopping.user.service.domain.exeception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class GetUserCommandHandler {

    // private final  orderDataMapper;

    private final UserRepository userRepository;
    private final UserDataMapper userDataMapper;

    public GetUserCommandHandler(UserRepository userRepository, UserDataMapper userDataMapper) {
        this.userRepository = userRepository;
        this.userDataMapper = userDataMapper;
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(UUID userID) {
        Optional<User> user = userRepository.getUser(new UserId(userID));
           if (user.isEmpty()) {
               log.warn("Could not find user with id: {}", userID);
               throw new UserNotFoundException("Could not find user with id: " +
                       userID);
           }
           return userDataMapper.userToUserResponse(user.get());
    }
}
