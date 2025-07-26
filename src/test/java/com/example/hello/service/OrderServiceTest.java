package com.example.hello.service;

import com.example.hello.dao.OrderEntity;
import com.example.hello.dao.repository.OrderRepository;
import com.example.hello.mapper.OrderMapper;
import com.example.hello.model.OrderDto;
import com.example.hello.rabbit.MessageProducer;
import com.example.hello.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private MessageProducer messageProducer;

    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository, orderMapper, messageProducer);
    }

    @Test
    void createOrder_withInvalidPrice_shouldThrowException() {
        OrderDto dto = new OrderDto();
        dto.setPrice(BigDecimal.ZERO);
        dto.setName("Test");
        dto.setQuantity(1);

        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(dto));
    }

    @Test
    void createOrder_withValidPrice_shouldSendPayment() {
        OrderDto dto = new OrderDto();
        dto.setPrice(BigDecimal.valueOf(100));
        dto.setName("Valid Product");
        dto.setQuantity(2);

        orderService.createOrder(dto);

        verify(messageProducer).sendPayment(any());
    }

    @Test
    void getById_shouldReturnOrderDto() {
        OrderEntity entity = OrderEntity.builder()
                .id(1L)
                .name("Test Product")
                .quantity(2)
                .price(BigDecimal.valueOf(150))
                .build();

        when(orderRepository.findById(1L)).thenReturn(Optional.of(entity));

        OrderDto dto = orderService.getById(1L);
        assertThat(dto).isNotNull();
        assertThat(dto.getName()).isEqualTo("Test Product");
    }

    @Test
    void check_shouldPrintCheck() {
        orderService.check();
    }
}
