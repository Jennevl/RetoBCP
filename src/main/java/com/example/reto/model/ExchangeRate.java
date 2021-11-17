package com.example.reto.model;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


/**
 * Model ExchangeRate
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String monedaOrigen;
	private Float montoOrigen;
	private String monedaDestino;
	private Float tipoCambio;
	private Float montoDestino;
	private Date fechaTrx;
	private String usuarioTrx;
}
