package com.in28minutes.microservices.currencyconversionservice.model;

import jakarta.annotation.security.DenyAll;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

@Document(collection = "currency_conversion")
public class CurrencyConversion {

    private String id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private String environment;
}
