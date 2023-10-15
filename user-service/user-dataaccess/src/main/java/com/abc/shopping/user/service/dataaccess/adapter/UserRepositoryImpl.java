package com.abc.shopping.user.service.dataaccess.adapter;

import com.abc.shopping.domain.valueobject.UserId;
import com.abc.shopping.user.service.dataaccess.mapper.UserDataAccessMapper;
import com.abc.shopping.user.service.dataaccess.repository.UserJpaRepository;
import com.abc.shopping.user.service.domain.application.ports.output.repository.UserRepository;
import com.abc.shopping.user.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    UserJpaRepository userJpaRepository;
    UserDataAccessMapper userDataAccessMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserDataAccessMapper userDataAccessMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public Optional<User> getUser(UserId userId) {
        return userJpaRepository.findById(userId.getValue())
                .map(userDataAccessMapper::userEntityTouser);
    }
}
