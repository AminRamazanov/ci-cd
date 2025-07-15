package com.example.hello.mapper;

import com.example.hello.dao.OrderEntity;
import com.example.hello.model.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toEntity(OrderDto orderDto);

    OrderDto toDto(OrderEntity orderEntity);
}
