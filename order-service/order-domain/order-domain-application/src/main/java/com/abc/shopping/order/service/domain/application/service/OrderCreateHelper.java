package com.abc.shopping.order.service.domain.application.service;

import com.abc.shopping.order.service.domain.OrderDomainService;
import com.abc.shopping.order.service.domain.application.dto.create.CreateOrderCommand;
import com.abc.shopping.order.service.domain.application.mapper.OrderDataMapper;
import com.abc.shopping.order.service.domain.application.ports.output.repository.CustomerRepository;
import com.abc.shopping.order.service.domain.application.ports.output.repository.DeliveryRepository;
import com.abc.shopping.order.service.domain.application.ports.output.repository.OrderRepository;
import com.abc.shopping.order.service.domain.entity.Customer;
import com.abc.shopping.order.service.domain.entity.Delivery;
import com.abc.shopping.order.service.domain.entity.Order;
import com.abc.shopping.order.service.domain.event.OrderCreatedEvent;
import com.abc.shopping.order.service.domain.exception.OrderDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateHelper {

    private final OrderDomainService orderDomainService;

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final DeliveryRepository deliveryRepository;

    private final OrderDataMapper orderDataMapper;

    public OrderCreateHelper(OrderDomainService orderDomainService,
                             OrderRepository orderRepository,
                             CustomerRepository customerRepository,
                             DeliveryRepository deliveryRepository,
                             OrderDataMapper orderDataMapper) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.deliveryRepository = deliveryRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Delivery delivery = checkDelivery(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, delivery);
        saveOrder(order);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        return orderCreatedEvent;
    }

    private Delivery checkDelivery(CreateOrderCommand createOrderCommand) {
        Delivery delivery = orderDataMapper.createOrderCommandToDelivery(createOrderCommand);
        Optional<Delivery> optionalRestaurant = deliveryRepository.findDeliveryInformation(delivery);
        if (optionalRestaurant.isEmpty()) {
            log.warn("Could not find restaurant with restaurant id: {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Could not find restaurant with restaurant id: " +
                    createOrderCommand.getRestaurantId());
        }
        return optionalRestaurant.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customer);
        }
    }

    private Order saveOrder(Order order) {
        Order orderResult = orderRepository.save(order);
        if (orderResult == null) {
            log.error("Could not save order!");
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order is saved with id: {}", orderResult.getId().getValue());
        return orderResult;
    }
}
