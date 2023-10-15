package com.abc.shopping.user.service.domain.application.ports.output.repository;

import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.user.service.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(UserId userId);
}
