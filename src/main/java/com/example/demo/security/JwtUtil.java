package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets; // Required import

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // A secure 256-bit key
    private final String SECRET_KEY = "this_is_a_very_secure_and_long_secret_key_at_least_32_chars";

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().name());
        claims.put("email", user.getEmail());
        claims.put("userId", user.getId());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                // FIX: Use .getBytes() to treat the string as raw data
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    // ---- Methods directly used in tests ----

    public String extractRole(String token) {
        try {
            return extractAllClaims(token).get("role", String.class);
        } catch (Exception e) {
            return null;
        }
    }

    public String extractEmail(String token) {
        try {
            return extractAllClaims(token).get("email", String.class);
        } catch (Exception e) {
            return "";
        }
    }

    public Long extractUserId(String token) {
        try {
            return extractAllClaims(token).get("userId", Long.class);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateToken(String token, String username) {
        if (token == null || username == null) return false;
        try {
            String email = extractEmail(token);
            return username.equals(email);
        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                // FIX: Use .getBytes() here as well
                .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }
}