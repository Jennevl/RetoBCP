package com.example.reto.response;

import lombok.*;

/**
 * Response de Security
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SecurityResponse {
	private String tipoToken;
	private Long tiempoExpira;
	private String token;
}
