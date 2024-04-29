package com.in28minutes.microservices.currencyexchangeservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

@Document(collection = "currency_exchange")
public class CurrencyExchange {

    @Id
    private String id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

}
