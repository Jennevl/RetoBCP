package com.example.reto.repository;

import com.example.reto.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository ExchangeRate
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
}
