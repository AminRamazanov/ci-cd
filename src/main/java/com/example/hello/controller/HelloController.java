package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, CI/CD is working!" +
                "Hello, CI/CD is working!" +
                "Hello, CI/CD is working!";

    }

    @GetMapping("/goodBye")
    public String goodBye(){
        return "Goodbye!";
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "HelloWorld!";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome!";
    }
}

