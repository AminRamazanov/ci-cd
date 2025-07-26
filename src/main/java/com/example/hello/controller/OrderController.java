package com.example.hello.controller;

import com.example.hello.model.OrderDto;
import com.example.hello.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto){
        System.out.println("hello");
        orderService.createOrder(orderDto);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/bye")
    public String bye(){
        return "Bye";
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id){
        return orderService.getById(id);
    }
}

