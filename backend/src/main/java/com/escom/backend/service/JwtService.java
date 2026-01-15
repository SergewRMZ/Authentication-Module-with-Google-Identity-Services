package com.escom.backend.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
  private final Key secretKey;


  public JwtService(@Value("${jwt.secret}") String secretKeyBase64) {
    byte[] secretKeyBytes = Base64.getDecoder().decode(secretKeyBase64);
    this.secretKey = Keys.hmacShaKeyFor(secretKeyBytes);
  }

  public String generateToken (UUID userId, String email) {
    return Jwts.builder()
      .setSubject(userId.toString())
      .claim("email", email)
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 3600000))
      .signWith(secretKey)
      .compact();
  }

  public Claims validateToken(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(secretKey)
      .build()
      .parseClaimsJws(token)
      .getBody();
  }
}
