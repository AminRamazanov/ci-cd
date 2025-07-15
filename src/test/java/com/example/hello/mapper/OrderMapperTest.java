package com.example.hello.mapper;

import com.example.hello.dao.OrderEntity;
import com.example.hello.model.OrderDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class OrderMapperTest {

    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Test
    void testToDto() {
        OrderEntity entity = OrderEntity.builder()
                .id(1L)
                .name("Mapper Product")
                .quantity(5)
                .price(BigDecimal.valueOf(500))
                .build();

        OrderDto dto = orderMapper.toDto(entity);

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Mapper Product");
        assertThat(dto.getQuantity()).isEqualTo(5);
        assertThat(dto.getPrice()).isEqualTo(BigDecimal.valueOf(500));
    }

    @Test
    void testToEntity() {
        OrderDto dto = new OrderDto();
        dto.setId(2L);
        dto.setName("Entity Test");
        dto.setQuantity(3);
        dto.setPrice(BigDecimal.valueOf(300));

        OrderEntity entity = orderMapper.toEntity(dto);

        assertThat(entity.getId()).isEqualTo(2L);
        assertThat(entity.getName()).isEqualTo("Entity Test");
        assertThat(entity.getQuantity()).isEqualTo(3);
        assertThat(entity.getPrice()).isEqualTo(BigDecimal.valueOf(300));
    }
}
