package com.abc.shopping.product.service.application.controller;

import com.abc.shopping.product.service.domain.application.dto.get.ProductResponse;
import com.abc.shopping.product.service.domain.application.ports.input.service.ProductApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/product", produces = "application/vnd.api.v1+json")
public class ProductController {

    private final ProductApplicationService productApplicationService;
//
    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getproduct(@PathVariable UUID productId) {

        ProductResponse productResponse = productApplicationService.getProduct(productId);
        return ResponseEntity.ok(productResponse);
    }
}
