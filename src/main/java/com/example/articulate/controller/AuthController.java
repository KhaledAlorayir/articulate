package com.example.articulate.controller;

import com.example.articulate.dto.auth.LoginRequest;
import com.example.articulate.dto.auth.LoginResponse;
import com.example.articulate.repository.UserRepository;
import com.example.articulate.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.articulate.constant.Constants.API.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
