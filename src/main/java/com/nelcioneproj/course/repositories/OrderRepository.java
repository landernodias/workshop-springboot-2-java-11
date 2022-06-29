package com.nelcioneproj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelcioneproj.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
