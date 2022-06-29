package com.nelcioneproj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelcioneproj.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
