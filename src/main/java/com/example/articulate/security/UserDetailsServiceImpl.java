package com.example.articulate.security;

import com.example.articulate.entity.PlatformUser;
import com.example.articulate.repository.UserRepository;
import com.example.articulate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PlatformUser platformUser = userService.getUserByIdentifier(username);
        return new User(platformUser.getUsername(), platformUser.getPassword(), List.of());
    }
}
