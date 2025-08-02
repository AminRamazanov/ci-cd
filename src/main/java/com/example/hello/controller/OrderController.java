package com.example.hello.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    @Value("${USER_NAME}")
    private String name;
    @Value("${USER_SURNAME}")
    private String surname;
    @Value("${USER_EMAIL}")
    private String email;


    @GetMapping("/hello")
    public String hello() {
        User user = new User(name, surname, email);
        System.out.println(user);
        System.out.println("hello");
        System.out.println("hello"+ surname);
        return "Hello";
    }

    @GetMapping("/bye")
    public String bye() {

        return "Bye";
    }

    @GetMapping("/privet")
    public String privet() {
        return "Privet";
    }

    @GetMapping("/kakDela")
    public String kakDela() {
        return "kakDela";
    }

    @GetMapping("/k")
    public String k() {
        return "k";
    }

    @GetMapping("/b")
    public String b() {
        return "b";
    }

    @GetMapping("/z")
    public String z() {
        return "z";
    }

    @GetMapping("/v")
    public String v() {
        return "v";
    }
}

