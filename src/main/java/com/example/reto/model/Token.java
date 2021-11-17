package com.example.reto.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Token {
	private Long tiempoExpira;
	private String token;
}
