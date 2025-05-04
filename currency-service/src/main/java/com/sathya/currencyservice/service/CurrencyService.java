package com.sathya.currencyservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.currencyservice.CurrencyDetails;
import com.sathya.currencyservice.CurrencyRequest;
import com.sathya.currencyservice.controller.CurrencyController;
import com.sathya.currencyservice.feignClient.FeignClientCode;
import com.sathya.currencyservice.repository.CurrencyRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service 
public class CurrencyService 
{
  @Autowired
  private CurrencyRepository currencyRepository;
  
  @Autowired
  FeignClientCode feignClientCode;
@CircuitBreaker(name = "CurrencyService", fallbackMethod = "getfallbackdetails")
public CurrencyDetails save(CurrencyRequest currencyRequest) 
{
	//double conversionRate=87;
	
	
	CurrencyDetails currencyDetails=new CurrencyDetails();
	Logger logger=LoggerFactory.getLogger(CurrencyService.class);
	 logger.warn("This data is saved successfullly "+currencyRequest);
	currencyDetails.setFromCurrency(currencyRequest.getFromCurrency());
	currencyDetails.setToCurrency(currencyRequest.getToCurrency());
	currencyDetails.setQuantity(currencyRequest.getQuantity());
	
	double conversionRate=feignClientCode.getDetails(currencyRequest.getFromCurrency(),currencyRequest.getToCurrency()).getBody();
	double totalAmount= conversionRate * currencyRequest.getQuantity();
	currencyDetails.setConversionRate(conversionRate);
	currencyDetails.setTotalAmount(totalAmount);
	
	return currencyRepository.save(currencyDetails);

	 
}
public CurrencyDetails getfallbackdetails(CurrencyRequest currencyRequest,Throwable t) 
{

	 
	
	  CurrencyDetails currencyDetails=new CurrencyDetails();
	  Logger logger=LoggerFactory.getLogger(CurrencyService.class);
	  logger.warn("This data is not retrieved "+currencyRequest);
	  currencyDetails.setFromCurrency(currencyRequest.getFromCurrency());
	  currencyDetails.setToCurrency(currencyRequest.getToCurrency());
	  currencyDetails.setQuantity(currencyRequest.getQuantity());
	  currencyDetails.setConversionRate(1.0); currencyDetails.setTotalAmount(1.0 *
	  currencyRequest.getQuantity());
	  
	  return currencyDetails;
	 
	
	//throw new RuntimeException("Curency exchange service is down please try again later...");
	
}

}
