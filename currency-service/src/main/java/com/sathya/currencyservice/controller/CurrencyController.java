package com.sathya.currencyservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.currencyservice.CurrencyDetails;
import com.sathya.currencyservice.CurrencyRequest;
import com.sathya.currencyservice.service.CurrencyService;

@RestController
@RequestMapping("/api/v1")
@RefreshScope

public class CurrencyController 
{ 
	Logger logger=LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private CurrencyService currencyService;
	
	
	@Value("${my.custom.property}")
	private String customMessage;
	
 @PostMapping("/Currency")
 public ResponseEntity<CurrencyDetails> getCurrencyDetails(@RequestBody CurrencyRequest currencyRequest) 
 { 
	 logger.trace("This is Trace log Request is coming with input "+currencyRequest);
	 logger.info("This is Info log "+currencyRequest);
	 
	 
	 CurrencyDetails saveDetails=currencyService.save(currencyRequest);
	 
	 logger.trace("This is Trace Response "+saveDetails);
	 logger.info("This is Info Response "+saveDetails);
	 
     return ResponseEntity.status(HttpStatus.CREATED)
    		               .header("info","Data save Succesfully.."+customMessage)
    		               .body(saveDetails);
 }
 
}
