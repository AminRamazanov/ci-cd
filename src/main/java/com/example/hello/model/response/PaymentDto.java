package com.example.hello.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDto {
    private String name;

    private BigDecimal price;
}
