package com.sathya.currencyservice;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRequest {
	
   private String fromCurrency;
   private String toCurrency;
   private int quantity;
   
}
