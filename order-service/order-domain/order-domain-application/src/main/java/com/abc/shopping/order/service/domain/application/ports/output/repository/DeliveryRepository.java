package com.abc.shopping.order.service.domain.application.ports.output.repository;

import com.abc.shopping.order.service.domain.entity.Delivery;

import java.util.Optional;

public interface DeliveryRepository {

    Optional<Delivery> findDeliveryInformation(Delivery delivery);
}
