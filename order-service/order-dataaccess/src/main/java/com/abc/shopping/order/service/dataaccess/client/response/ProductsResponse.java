package com.abc.shopping.order.service.dataaccess.client.response;

import com.abc.shopping.order.service.domain.application.dto.create.ProductDto;
import com.abc.shopping.order.service.domain.application.dto.create.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ProductsResponse {
    public List<ProductDto> products;
    public List<String> failureMessages;

    public ProductsResponse() {
    }
}


