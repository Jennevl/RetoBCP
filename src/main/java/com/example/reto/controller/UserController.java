package com.example.reto.controller;

import com.example.reto.model.Token;
import com.example.reto.response.SecurityResponse;
import com.example.reto.util.JWTToken;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
	@PostMapping("/user")
	@ResponseBody
	public Mono<SecurityResponse> login(@RequestHeader("usuarioTrx") String usuarioTrx, @RequestHeader("password") String pwd) {
		SecurityResponse securityResponse = new SecurityResponse();
		if (usuarioTrx.equals("sa") && pwd.equals("12345678")) {
			Token tokens = JWTToken.getJWTToken(usuarioTrx);
			securityResponse.setToken(tokens.getToken());
			securityResponse.setTiempoExpira(tokens.getTiempoExpira());
			securityResponse.setTipoToken("Bearer");
		}

		return Mono.just(securityResponse);

	}
}
