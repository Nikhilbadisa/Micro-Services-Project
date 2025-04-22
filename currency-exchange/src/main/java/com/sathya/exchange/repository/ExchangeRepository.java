package com.sathya.exchange.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.exchange.CurrencyExchange;


@Repository
public interface ExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	Optional<CurrencyExchange> findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}