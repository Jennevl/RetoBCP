package com.example.reto.controller;

import com.example.reto.request.ExchangeRequest;
import com.example.reto.response.ExchangeResponse;
import com.example.reto.service.impl.ExchangeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExchangeController {
	private final ExchangeServiceImpl exchangeService;

	@PostMapping("/exchange")
	@ResponseBody
	public Mono<ExchangeResponse> calculateExchangeRate(@RequestBody ExchangeRequest request,
																											@RequestHeader("usuarioTrx") String usuarioTrx) {
		ExchangeResponse exchangeResponse = new ExchangeResponse();
		try {
			BigDecimal montoDestino = BigDecimal.ZERO;
			montoDestino = exchangeService.calcular(request.getMonedaOrigen(),request.getMontoOrigen(),request.getMonedaDestino(),request.getTipoCambio(),usuarioTrx);
			exchangeResponse.setMontoDestino(montoDestino);
			exchangeResponse.setMensaje("Calculo correcto");
			exchangeResponse.setMonedaDestino(request.getMonedaDestino());
		}catch (Exception ex){
			log.error(ex.getLocalizedMessage());
		}
		return Mono.just(exchangeResponse);
	}
}
