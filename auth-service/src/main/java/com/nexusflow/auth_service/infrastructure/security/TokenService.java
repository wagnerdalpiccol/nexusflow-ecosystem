package com.nexusflow.auth_service.infrastructure.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.nexusflow.auth_service.domain.model.User;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class TokenService {

	@Value("${api.security.token.secret:minha-senha-super-secreta-de-32-caracteres}")
	private String secret;

	public String generateToken(User user) {
		SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

		return Jwts.builder().subject(user.getEmail()).claim("id", user.getId()).claim("name", user.getName())
				.issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + 86400000)) // 24 horas de
																									// validade
				.signWith(key).compact();
	}

	public String validateToken(String token) {
		try {
			SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
			return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
		} catch (Exception e) {
			return null;
		}
	}
}
