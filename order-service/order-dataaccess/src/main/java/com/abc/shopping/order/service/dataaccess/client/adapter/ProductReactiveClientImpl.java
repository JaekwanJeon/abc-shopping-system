package com.abc.shopping.order.service.dataaccess.client.adapter;

import com.abc.shopping.order.service.dataaccess.client.response.ProductsResponse;
import com.abc.shopping.order.service.domain.application.dto.create.ProductDto;
import com.abc.shopping.order.service.domain.application.dto.create.UserDto;
import com.abc.shopping.order.service.domain.application.ports.output.repository.ProductReactiveClient;
import com.abc.shopping.order.service.domain.application.ports.output.repository.UserReactiveClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductReactiveClientImpl implements ProductReactiveClient {

    private final WebClient webClient;

    private final String PRODUCT_PATH = "/product";


    public ProductReactiveClientImpl(final WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<ProductDto> findProducts(List<UUID> productIds) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(PRODUCT_PATH)
                        .queryParam("params", productIds.stream().map(UUID::toString).toList())
                        .build())
//                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ProductsResponse.class)
                .flatMapMany(productsResponse ->
                        Flux.fromIterable(productsResponse.getProducts()));
    }
}
