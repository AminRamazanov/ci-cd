package com.example.hello.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloEndpoint_shouldReturnHello() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/order/hello", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello");
    }

    @Test
    void byeEndpoint_shouldReturnBye() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/order/bye", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Bye");
    }

    @Test
    void privetEndpoint_shouldReturnPrivet() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/order/privet", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Privet");
    }

    @Test
    void kakDelaEndpoint_shouldReturnKakDela() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/order/kakDela", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("kakDela");
    }

    @Test
    void kEndpoint_shouldReturnK() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/order/k", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("k");
    }

}
