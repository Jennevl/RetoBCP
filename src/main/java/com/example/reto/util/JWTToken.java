package com.example.reto.util;

import com.example.reto.model.Token;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTToken {
	public JWTToken() {

	}

	public static final Token getJWTToken(String username) {
		String secretKey = "mySecretKey";
		Token tokens = new Token();
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		long tiempoExpira = System.currentTimeMillis() + 300000;

		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(tiempoExpira))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		tokens.setToken(token);
		tokens.setTiempoExpira(tiempoExpira);

		return tokens;
	}
}
