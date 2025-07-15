package com.example.hello.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto {
    private Long id;

    private Integer quantity;

    private String name;

    private BigDecimal price;
}
