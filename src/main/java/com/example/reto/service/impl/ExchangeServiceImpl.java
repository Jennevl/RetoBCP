package com.example.reto.service.impl;

import com.example.reto.model.ExchangeRate;
import com.example.reto.repository.ExchangeRateRepository;
import com.example.reto.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeServiceImpl {

	private final ExchangeRateRepository exchangeRateRepository;

	/**
	 * Utilizando lambda java 8
	 *
	 * @param monedaOrigen
	 * @param montoOrigen
	 * @param monedaDestino
	 * @param tipoCambio
	 * @return
	 */
	public BigDecimal calcular(String monedaOrigen, BigDecimal montoOrigen, String monedaDestino, BigDecimal tipoCambio, String usuarioTrx) {
		BigDecimal retorno = BigDecimal.ZERO;
		ExchangeRate exchangeRate = new ExchangeRate();
		ExchangeService exchangeService = (String moneda1, BigDecimal monto1, String moneda2, BigDecimal tipo) -> {
			if (moneda1.equals("PEN") && moneda2.equals("USD")) {
				return monto1.divide(tipo, 2, RoundingMode.HALF_UP);
			} else {
				return monto1.multiply(tipo);
			}
		};
		retorno = exchangeService.calculate(monedaOrigen, montoOrigen, monedaDestino, tipoCambio);
		exchangeRate.setFechaTrx(new Date());
		exchangeRate.setMonedaDestino(monedaDestino);
		exchangeRate.setMonedaOrigen(monedaOrigen);
		exchangeRate.setMontoDestino(retorno.floatValue());
		exchangeRate.setMontoOrigen(montoOrigen.floatValue());
		exchangeRate.setTipoCambio(tipoCambio.floatValue());
		exchangeRate.setUsuarioTrx(usuarioTrx);
		exchangeRateRepository.save(exchangeRate);
		imprimirTasas();
		return retorno;
	}

	/**
	 * Impresion de tasas
	 */
	public void imprimirTasas() {
		log.info("Imprimiendo tasas");
		exchangeRateRepository.findAll().forEach(rate -> {
			log.info(rate.toString());
		});
	}
}
