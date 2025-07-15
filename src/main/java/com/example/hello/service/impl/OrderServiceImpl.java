package com.example.hello.service.impl;

import com.example.hello.dao.OrderEntity;
import com.example.hello.dao.repository.OrderRepository;
import com.example.hello.mapper.OrderMapper;
import com.example.hello.model.OrderDto;
import com.example.hello.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public void createOrder(OrderDto orderDto) {
        log.info("Action.log.createOrder started for order {}", orderDto.getId());

        OrderEntity orderEntity = orderMapper.toEntity(orderDto);
        if (orderEntity.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        orderEntity = orderRepository.save(orderEntity);

        log.info("Action.log.createOrder ended for order {}", orderDto.getId());

    }

    @Override
    public OrderDto getById(Long id) {
        log.info("Action.log.getById started for order {}", id);
        OrderEntity orderEntity = orderRepository.findById(id)
                        .orElseThrow(()-> new EntityNotFoundException("Order not found"));
        OrderDto orderDto = orderMapper.toDto(orderEntity);
        log.info("Action.log.getById ended for order {}", id);
        return orderDto;
    }
}
