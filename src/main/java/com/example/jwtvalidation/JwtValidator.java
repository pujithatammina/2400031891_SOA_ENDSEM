package com.example.jwtvalidation;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

@Component
public class JwtValidator {

    private final SecretKey key = Keys.hmacShaKeyFor(
        "MySecretKeyForJWTValidation123456789".getBytes()
    );

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}