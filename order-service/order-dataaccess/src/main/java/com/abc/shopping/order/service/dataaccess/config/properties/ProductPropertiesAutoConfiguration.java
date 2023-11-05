package com.abc.shopping.order.service.dataaccess.config.properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(ProductServiceProperties.class)
@EnableConfigurationProperties(ProductServiceProperties.class)
class ProductPropertiesAutoConfiguration {
}
