package com.nelcioneproj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelcioneproj.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
