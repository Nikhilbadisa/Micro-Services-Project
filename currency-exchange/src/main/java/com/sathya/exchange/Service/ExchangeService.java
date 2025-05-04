package com.sathya.exchange.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sathya.exchange.CurrencyExchange;
import com.sathya.exchange.repository.ExchangeRepository;

@Service
public class ExchangeService 
{
	@Autowired
	ExchangeRepository exchangeRepository;
	
	@Cacheable(value="currency-exchange",key="#fromCurrency + '_' + #toCurrency")
	public Double getConversionRate(String fromCurrency,String toCurrency)
	{
		System.out.println("DB/API call for exchange rate. ");
		
		Optional<CurrencyExchange> optional = exchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		
		if(optional.isPresent()) 
		{
			CurrencyExchange exchange=optional.get();
			return exchange.getConversionRate();
			
		}
		else 
		{
			return 0.0;
		}
	}

}
