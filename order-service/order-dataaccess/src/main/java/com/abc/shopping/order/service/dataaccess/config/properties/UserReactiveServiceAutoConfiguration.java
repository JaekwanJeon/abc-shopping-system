package com.abc.shopping.order.service.dataaccess.config.properties;

import com.abc.shopping.order.service.dataaccess.user.adapter.UserReactiveClientImpl;
import com.abc.shopping.order.service.domain.application.ports.output.repository.UserReactiveClient;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AutoConfigureAfter(WebClientAutoConfiguration.class)
class UserReactiveServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    UserReactiveClient userReactiveClient(
            final WebClient.Builder webClientBuilder,
            final UserServiceProperties userServiceProperties) {
        final var webClient =
                webClientBuilder
                        .baseUrl(userServiceProperties.apiUpstreamEntrypoint())
                        .build();

        return new UserReactiveClientImpl(webClient);
    }
}
