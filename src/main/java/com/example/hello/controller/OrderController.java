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

    @GetMapping("/privet")
    public String privet(){
        return "Privet";
    }

    @GetMapping("/kakDela")
    public String kakDela(){
        return "kakDela";
    }

    @GetMapping("/k")
    public String k(){
        return "k";
    }
}

