package com.example.articulate.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.articulate.entity.PlatformUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${JWT_SECRET}")
    private String JWT_SECRET;

    @Value("${JWT_EXPIRATION_IN_MS}")
    private long JWT_EXPIRATION_IN_MS;
    public String issueToken(PlatformUser platformUser) {
        Map<String,String> payload = new HashMap<>() {{
            put("username",platformUser.getUsername());
            put("email",platformUser.getEmail());
            put("phoneNumber",platformUser.getMobileNumber());
        }};

        return JWT.create()
                .withSubject(platformUser.getId().toString())
                .withClaim("role",platformUser.getPrivilege().getName().toString())
                .withPayload(payload)
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
                .sign(Algorithm.HMAC256(JWT_SECRET));
    }
}
