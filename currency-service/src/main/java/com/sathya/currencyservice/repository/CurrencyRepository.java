package com.sathya.currencyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.currencyservice.CurrencyDetails;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyDetails,Integer>
{

}
