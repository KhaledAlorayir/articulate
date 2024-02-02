package com.example.articulate.service;

import com.example.articulate.entity.Privilege;
import com.example.articulate.enums.PrivilegeEnum;
import com.example.articulate.exception.ServerErrorException;
import com.example.articulate.repository.PrivilegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.example.articulate.constant.Constants.CacheKeys.PRIVILEGE_CACHE_KEY;

@Service
@RequiredArgsConstructor
public class PrivilegeService {
    private final PrivilegeRepository privilegeRepository;

    @Cacheable(PRIVILEGE_CACHE_KEY)
    public Privilege getPrivilege(PrivilegeEnum privilegeEnum) {
        return privilegeRepository.findByName(privilegeEnum).orElseThrow(() -> new ServerErrorException("privilege: " + privilegeEnum.name() + " not found"));
    }
}
