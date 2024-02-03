package com.example.articulate.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.articulate.entity.PlatformUser;
import com.example.articulate.enums.PrivilegeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.articulate.constant.Constants.API.JWT_PRIVILEGE_CLAIM_KEY;

@Component
public class JwtUtil {
    @Value("${JWT_SECRET}")
    private String JWT_SECRET;

    @Value("${JWT_EXPIRATION_IN_MS}")
    private long JWT_EXPIRATION_IN_MS;

    public String issueToken(PlatformUser platformUser) {
        Map<String, String> payload = new HashMap<>() {{
            put("username", platformUser.getUsername());
            put("email", platformUser.getEmail());
            put("phoneNumber", platformUser.getMobileNumber());
        }};

        return JWT.create()
                .withSubject(platformUser.getId().toString())
                .withClaim(JWT_PRIVILEGE_CLAIM_KEY, platformUser.getPrivilege().getName().toString())
                .withPayload(payload)
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_EXPIRATION_IN_MS))
                .sign(Algorithm.HMAC256(JWT_SECRET));
    }

    public record DecodedTokenData(Long id, PrivilegeEnum privilege) {
    }

    public DecodedTokenData verifyTokenAndGetUserData(String token) {
        var data = JWT.require(Algorithm.HMAC256(JWT_SECRET)).build().verify(token);
        return new DecodedTokenData(Long.parseLong(data.getSubject()), PrivilegeEnum.valueOf(data.getClaim(JWT_PRIVILEGE_CLAIM_KEY).asString()));
    }
}

