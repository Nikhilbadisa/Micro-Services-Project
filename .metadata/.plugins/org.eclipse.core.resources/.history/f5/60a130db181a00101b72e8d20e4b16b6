package com.sathya.currencyservice;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String fromCurrency;
	private String toCurrency;
	private int quantity;
	private double conversionRate;
	private double totalAmount;
}
