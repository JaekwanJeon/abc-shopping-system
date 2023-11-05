package com.abc.shopping.order.service.dataaccess.config.properties;

import com.abc.shopping.order.service.dataaccess.client.adapter.ProductReactiveClientImpl;
import com.abc.shopping.order.service.dataaccess.client.adapter.UserReactiveClientImpl;
import com.abc.shopping.order.service.domain.application.ports.output.repository.ProductReactiveClient;
import com.abc.shopping.order.service.domain.application.ports.output.repository.UserReactiveClient;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AutoConfigureAfter(WebClientAutoConfiguration.class)
class ProductReactiveServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    ProductReactiveClient productReactiveClient(
            final WebClient.Builder webClientBuilder,
            final ProductServiceProperties productServiceProperties) {
        final var webClient =
                webClientBuilder
                        .baseUrl(productServiceProperties.apiUpstreamEntrypoint())
                        .build();

        return new ProductReactiveClientImpl(webClient);
    }
}
