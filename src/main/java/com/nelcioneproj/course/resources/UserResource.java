package com.nelcioneproj.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelcioneproj.course.entities.User;
import com.nelcioneproj.course.services.UserService;

//recurso web implementado por controlador web
@RestController
//nome do recurso
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	//endPoint: retorna todos usuarios
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();			
		return ResponseEntity.ok().body(list);
	}
	
	//retorna usuario por id
	@GetMapping(value = "/{id}") // a requisição vai aceitar um id na url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
