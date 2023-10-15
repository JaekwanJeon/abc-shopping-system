package com.abc.shopping.user.service.application.controller;

import com.abc.shopping.user.service.domain.application.dto.get.UserResponse;
import com.abc.shopping.user.service.domain.application.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/user", produces = "application/vnd.api.v1+json")
public class UserController {

    private final UserApplicationService userApplicationService;
//
    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID userId) {

        UserResponse userResponse = userApplicationService.getUser(userId);
        return ResponseEntity.ok(userResponse);
    }
}
