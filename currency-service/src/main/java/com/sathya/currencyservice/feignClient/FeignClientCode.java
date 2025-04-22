package com.sathya.currencyservice.feignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="currency-exchange")
public interface FeignClientCode {

	@GetMapping("/api/v1/from/{fromCurrency}/to/{toCurrency}")
	public ResponseEntity<Double> getDetails(@PathVariable("fromCurrency") String fromCurrency,@PathVariable("toCurrency") String toCurrency);
}
