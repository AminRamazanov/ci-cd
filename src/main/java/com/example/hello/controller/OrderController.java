package com.example.hello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {


    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/bye")
    public String bye(){
        return "Bye";
    }

}

