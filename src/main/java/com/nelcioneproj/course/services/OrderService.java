package com.nelcioneproj.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelcioneproj.course.entities.Order;
import com.nelcioneproj.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){ // retorna todos users
		return repository.findAll();
	}
	
	//recuperar um dado pelo Id
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); 
	}
	
}
