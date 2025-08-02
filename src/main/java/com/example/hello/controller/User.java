package com.example.hello.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ConfigurationProperties(prefix = "user")
public class User {
    @Value("${USER_NAME}")
    private String name;
    @Value("${USER_SURNAME}")
    private String surname;
    @Value("${USER_EMAIL}")
    private String email;
}
