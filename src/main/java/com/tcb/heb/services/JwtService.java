package com.tcb.heb.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    final long tokenExpirationInMs = 86_400_000; // 1day

    public String generateToken(String email) {
        return Jwts.builder()
            .subject(email)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + tokenExpirationInMs))
            .signWith(Keys.hmacShaKeyFor("secret".getBytes()))
            .compact();
    }
}
