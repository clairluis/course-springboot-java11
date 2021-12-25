package com.clj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clj.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
