package com.example.reto.request;

import java.math.BigDecimal;

import lombok.*;


/**
 * Request de Exchange
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ExchangeRequest {

	private String monedaOrigen;


	private BigDecimal montoOrigen;


	private String monedaDestino;


	private BigDecimal tipoCambio;


}
