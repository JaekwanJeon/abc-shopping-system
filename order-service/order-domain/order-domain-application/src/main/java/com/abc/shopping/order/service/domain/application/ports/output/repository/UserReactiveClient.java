package com.abc.shopping.order.service.domain.application.ports.output.repository;


import com.abc.shopping.order.service.domain.application.dto.create.UserDto;
import com.abc.shopping.order.service.domain.entity.User;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface UserReactiveClient {

    Mono<UserDto> findUser(UUID customerId);

}
