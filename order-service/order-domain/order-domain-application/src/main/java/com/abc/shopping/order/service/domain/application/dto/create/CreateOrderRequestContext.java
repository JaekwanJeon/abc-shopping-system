package com.abc.shopping.order.service.domain.application.dto.create;

import com.abc.shopping.order.service.domain.entity.Order;
import com.abc.shopping.order.service.domain.entity.Product;
import com.abc.shopping.order.service.domain.entity.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CreateOrderRequestContext {

    private CreateOrderCommand createOrderCommand;
    private UserDto user;
    private Order order;
    private List<Product> productList;

    public CreateOrderRequestContext(CreateOrderCommand createOrderCommand) {
        this.createOrderCommand = createOrderCommand;
    }
}
