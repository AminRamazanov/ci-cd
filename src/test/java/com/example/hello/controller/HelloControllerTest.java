package com.example.hello.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloEndpointReturnsExpectedText() {
        String body = restTemplate.getForObject("/", String.class);
        assertThat(body).isEqualTo("Hello, CI/CD is working!Hello, CI/CD is working!Hello, CI/CD is working!");
    }

    @Test
    void goodbyeEndpointReturnsExpectedText() {
        String body = restTemplate.getForObject("/goodBye", String.class);
        assertThat(body).isEqualTo("Goodbye!");
    }

    @Test
    void helloWorldEndpointReturnsExpectedText() {
        String body = restTemplate.getForObject("/helloWorld", String.class);
        assertThat(body).isEqualTo("HelloWorld!");
    }

    @Test
    void welcomeeEndpointReturnsExpectedText() {
        String body = restTemplate.getForObject("/welcomee", String.class);
        assertThat(body).isEqualTo("Welcomee!");
    }
}

