package com.nelcioneproj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelcioneproj.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
