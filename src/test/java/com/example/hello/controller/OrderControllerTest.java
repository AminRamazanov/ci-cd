package com.example.hello.controller;

import com.example.hello.model.OrderDto;
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
    void createOrderAndGetByIdTest() {
        OrderDto orderDto = new OrderDto();
        orderDto.setName("Controller Test Product");
        orderDto.setQuantity(1);
        orderDto.setPrice(BigDecimal.valueOf(100));

        ResponseEntity<Long> createResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/order", orderDto, Long.class);
        assertThat(createResponse.getStatusCode().is2xxSuccessful()).isTrue();
        Long id = createResponse.getBody();
        assertThat(id).isNotNull();

        ResponseEntity<OrderDto> getByIdResponse = restTemplate.getForEntity(
                "http://localhost:" + port + "/order/" + id, OrderDto.class);
        assertThat(getByIdResponse.getBody()).isNotNull();
        assertThat(getByIdResponse.getBody().getName()).isEqualTo("Controller Test Product");
    }

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

}
