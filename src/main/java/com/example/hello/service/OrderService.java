package com.example.hello.service;

import com.example.hello.model.OrderDto;

public interface OrderService {
    void createOrder(OrderDto orderDto);

    OrderDto getById(Long id);
}
