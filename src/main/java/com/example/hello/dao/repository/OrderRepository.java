package com.example.hello.dao.repository;

import com.example.hello.dao.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
