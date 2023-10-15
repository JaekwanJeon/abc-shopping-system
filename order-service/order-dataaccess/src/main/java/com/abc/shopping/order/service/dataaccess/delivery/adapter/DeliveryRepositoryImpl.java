package com.abc.shopping.order.service.dataaccess.delivery.adapter;

import com.abc.shopping.order.service.dataaccess.delivery.mapper.RestaurantDataAccessMapper;
import com.abc.shopping.order.service.domain.application.ports.output.repository.DeliveryRepository;
import com.abc.shopping.order.service.domain.entity.Delivery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DeliveryRepositoryImpl implements DeliveryRepository {
    @Override
    public Optional<Delivery> findDeliveryInformation(Delivery delivery) {
        return Optional.empty();
    }

//    private final RestaurantJpaRepository restaurantJpaRepository;
//    private final RestaurantDataAccessMapper restaurantDataAccessMapper;
//
//    public DeliveryRepositoryImpl(RestaurantJpaRepository restaurantJpaRepository,
//                                  RestaurantDataAccessMapper restaurantDataAccessMapper) {
//        this.restaurantJpaRepository = restaurantJpaRepository;
//        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
//    }
//
//    @Override
//    public Optional<Delivery> findDeliveryInformation(Delivery delivery) {
//        List<UUID> deliveryProducts =
//                restaurantDataAccessMapper.restaurantToRestaurantProducts(delivery);
//        Optional<List<RestaurantEntity>> restaurantEntities = restaurantJpaRepository
//                .findByRestaurantIdAndProductIdIn(restaurant.getId().getValue(),
//                        restaurantProducts);
//        return restaurantEntities.map(restaurantDataAccessMapper::restaurantEntityToRestaurant);
//    }
}
