package com.in28minutes.microservices.currencyconversionservice.controller;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.model.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;


@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;


    //              --------------       This method will be working with RestTemplate
//    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversion calculateCurrencyConversion(
//                        @PathVariable String from,
//                        @PathVariable String to,
//                        @PathVariable BigDecimal quantity){
//
//
//        HashMap<String,String> uriVariables = new HashMap<>();
//        uriVariables.put("from",from);
//        uriVariables.put("to",to);
//
//        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:9091/currency-exchange/from/{from}/to/{to}",
//                CurrencyConversion.class, uriVariables);
//
//        CurrencyConversion currencyConversion = responseEntity.getBody();
//
//        return new CurrencyConversion(
//                currencyConversion.getId(),
//                from,
//                to,
//                quantity,
//                currencyConversion.getConversionMultiple(),
//                quantity.multiply(currencyConversion.getConversionMultiple()),
//                currencyConversion.getEnvironment() + " " + "rest templates");
//    }


    //------------------------->      This will be working with using openFeign client

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
                        @PathVariable String from,
                        @PathVariable String to,
                        @PathVariable BigDecimal quantity){
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from,to);
        return new CurrencyConversion(
                currencyConversion.getId(),
                from,
                to,
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " " + "using open feign ");
    }
    @GetMapping("/currency-conversion-feign")
    public List<CurrencyConversion> getAll(){
        return this.currencyExchangeProxy.getAllCurrencyExchange();
    }

}
