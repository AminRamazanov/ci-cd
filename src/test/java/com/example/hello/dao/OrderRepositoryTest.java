package com.example.hello.dao;

import com.example.hello.dao.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveAndFindByIdTest() {
        OrderEntity order = OrderEntity.builder()
                .name("Repo Test")
                .quantity(2)
                .price(BigDecimal.valueOf(250))
                .build();

        OrderEntity saved = orderRepository.save(order);
        Optional<OrderEntity> found = orderRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Repo Test");
    }
}
