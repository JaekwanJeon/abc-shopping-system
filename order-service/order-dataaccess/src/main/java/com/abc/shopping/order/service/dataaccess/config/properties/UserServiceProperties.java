package com.abc.shopping.order.service.dataaccess.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Objects;

@ConfigurationProperties("service.user")
public record UserServiceProperties(
    @DefaultValue("http://localhost:8089") String apiUpstreamEntrypoint
) {

    public UserServiceProperties {
        Objects.requireNonNull(apiUpstreamEntrypoint);
    }
}
