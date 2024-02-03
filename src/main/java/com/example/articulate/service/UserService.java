package com.example.articulate.service;

import com.example.articulate.dto.user.CreateUserRequest;
import com.example.articulate.entity.PlatformUser;
import com.example.articulate.entity.Privilege;
import com.example.articulate.enums.PrivilegeEnum;
import com.example.articulate.repository.PrivilegeRepository;
import com.example.articulate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PrivilegeService privilegeService;
    private final PasswordEncoder passwordEncoder;

    public void createUser(CreateUserRequest createUserRequest) {
        userRepository.save(new PlatformUser(
                createUserRequest.getUsername(),
                createUserRequest.getEmail(),
                passwordEncoder.encode(createUserRequest.getPassword()),
                createUserRequest.getMobileNumber(),
                privilegeService.getPrivilege(PrivilegeEnum.USER)
        ));
    }

    public PlatformUser getUserByIdentifier(String identifier) {
        return userRepository.findByIdentifier(identifier).orElseThrow(() -> new UsernameNotFoundException(identifier));
    }
}
