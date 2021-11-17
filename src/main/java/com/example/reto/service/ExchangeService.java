package com.example.reto.service;

import java.math.BigDecimal;


public interface ExchangeService {
	BigDecimal calculate(String monedaOrigen, BigDecimal montoOrigen,String monedaDestino, BigDecimal tipoCambio);
}
