package com.in28minutes.microservices.currencyexchangeservice.repository;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyExchangeRepository extends MongoRepository<CurrencyExchange,String> {

    CurrencyExchange findByFromAndTo(String from, String to);

}
