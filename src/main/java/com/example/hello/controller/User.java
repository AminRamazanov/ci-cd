package com.example.hello.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
//@ConfigurationProperties(prefix = "user")
public class User {
    @Value("${USER_NAME}")
    private String name;
    @Value("${USER_SURNAME}")
    private String surname;
    @Value("${USER_EMAIL}")
    private String email;
}
