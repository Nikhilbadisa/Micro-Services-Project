package com.sathya.Api_GateWay.jwtUtil;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
 
	// Use a more secure method to generate a secret key of at least 256 bits
    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // Generate JWT Token
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Set the subject (username)
                .setIssuedAt(new Date()) // Token issued time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Token expiration
                .signWith(SECRET_KEY) // Sign with the generated 256-bit key
                .compact();
    }
}
