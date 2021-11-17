package com.example.reto.response;

import java.math.BigDecimal;

import lombok.*;


/**
 * Response de Exchange
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExchangeResponse {

	private String monedaDestino;


	private BigDecimal montoDestino;


	private String mensaje;


}
