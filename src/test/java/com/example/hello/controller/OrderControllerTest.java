package com.example.hello.controller;

import com.example.hello.model.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

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

        ResponseEntity<Void> createResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/order", orderDto, Void.class);
        assertThat(createResponse.getStatusCode().is2xxSuccessful()).isTrue();

        // Тут обычно нужно получить id, но для простоты берём последнее сохранённое
        ResponseEntity<OrderDto[]> allOrders = restTemplate.getForEntity(
                "http://localhost:" + port + "/order", OrderDto[].class);
        assertThat(allOrders.getBody()).isNotEmpty();

        // Предполагаем, что последний созданный заказ можно проверить так:
        Long id = allOrders.getBody()[allOrders.getBody().length - 1].getId();
        ResponseEntity<OrderDto> getByIdResponse = restTemplate.getForEntity(
                "http://localhost:" + port + "/order/" + id, OrderDto.class);
        assertThat(getByIdResponse.getBody()).isNotNull();
        assertThat(getByIdResponse.getBody().getName()).isEqualTo("Controller Test Product");
    }
}
