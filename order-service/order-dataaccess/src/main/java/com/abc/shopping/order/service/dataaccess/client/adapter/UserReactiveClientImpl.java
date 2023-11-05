package com.abc.shopping.order.service.dataaccess.client.adapter;

import com.abc.shopping.order.service.dataaccess.client.response.UserResponse;
import com.abc.shopping.order.service.domain.application.dto.create.UserDto;
import com.abc.shopping.order.service.domain.application.ports.output.repository.UserReactiveClient;
import com.abc.shopping.order.service.domain.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserReactiveClientImpl implements UserReactiveClient {

    private final WebClient webClient;

    private final String USER_PATH = "/user";


    public UserReactiveClientImpl(final WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<UserDto> findUser(UUID userId) {
        return webClient.get()
                .uri(USER_PATH + "/{userId}", Map.of("userId",userId))
//                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .map(UserResponse::getUserDto);
    }

}
