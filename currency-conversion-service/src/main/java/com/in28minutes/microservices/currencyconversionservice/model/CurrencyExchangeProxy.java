package com.in28minutes.microservices.currencyconversionservice.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "currency-exchange",url = "localhost:9091")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

    @GetMapping("/currency-exchange/currency-exchange")
    public List<CurrencyConversion> getAllCurrencyExchange();
}
