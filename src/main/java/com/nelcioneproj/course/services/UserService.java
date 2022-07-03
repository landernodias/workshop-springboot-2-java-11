package com.nelcioneproj.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelcioneproj.course.entities.User;
import com.nelcioneproj.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){ // retorna todos users
		return repository.findAll();
	}
	
	//recuperar um dado pelo Id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); 
	}
	
	//save User
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//delete user
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	//update user
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); // só monitora o objeto não vai no banco de dados
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
