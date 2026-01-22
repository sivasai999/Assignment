package com.LBG.authservice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "my-secret-key-123456-my-secret-key";

    private static final long EXPIRATION_TIME = 60 * 60 * 1000; // 1 hour

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username, Long userId, List<String> roles) {

        return Jwts.builder()
                .setSubject(username)
                .addClaims(Map.of(
                        "userId", userId,
                        "roles", roles
                ))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}
