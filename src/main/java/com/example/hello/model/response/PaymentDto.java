package com.example.hello.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentDto {
    private String name;

    private BigDecimal price;
}
