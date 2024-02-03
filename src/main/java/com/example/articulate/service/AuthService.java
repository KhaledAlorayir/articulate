package com.example.articulate.service;

import com.example.articulate.dto.auth.LoginRequest;
import com.example.articulate.dto.auth.LoginResponse;
import com.example.articulate.entity.PlatformUser;
import com.example.articulate.repository.UserRepository;
import com.example.articulate.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getIdentifier(),loginRequest.getPassword()));
        PlatformUser platformUser = userService.getUserByIdentifier(loginRequest.getIdentifier());
        return new LoginResponse(jwtUtil.issueToken(platformUser));
    }


}
