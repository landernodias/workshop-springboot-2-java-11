package com.nelcioneproj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelcioneproj.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
