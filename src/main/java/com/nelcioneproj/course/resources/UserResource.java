package com.nelcioneproj.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelcioneproj.course.entities.User;

//recurso web implementado por controlador web
@RestController
//nome do recurso
@RequestMapping(value = "/users")
public class UserResource {

	//endPoint
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}