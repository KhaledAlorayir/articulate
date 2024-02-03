package com.example.articulate.controller;

import com.example.articulate.dto.user.CreateUserRequest;
import com.example.articulate.entity.PlatformUser;
import com.example.articulate.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static com.example.articulate.constant.Constants.API.API_PREFIX;
import static com.example.articulate.constant.Constants.ROLE.ADMIN_ROLE;
import static com.example.articulate.constant.Constants.ROLE.USER_ROLE;

@RestController
@RequestMapping(API_PREFIX + "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
