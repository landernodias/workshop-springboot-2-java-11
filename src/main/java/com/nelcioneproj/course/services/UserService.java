package com.nelcioneproj.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nelcioneproj.course.entities.User;
import com.nelcioneproj.course.repositories.UserRepository;
import com.nelcioneproj.course.services.exceptions.DatabaseException;
import com.nelcioneproj.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
	}
	
	//save User
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//delete user
	public void delete(Long id) {
		try {
			repository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	//update user
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id); // só monitora o objeto não vai no banco de dados
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
