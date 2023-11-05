package com.abc.shopping.order.service.dataaccess.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Objects;

@ConfigurationProperties("service.product")
public record ProductServiceProperties(
    @DefaultValue("http://localhost:8088") String apiUpstreamEntrypoint
) {

    public ProductServiceProperties {
        Objects.requireNonNull(apiUpstreamEntrypoint);
    }
}
