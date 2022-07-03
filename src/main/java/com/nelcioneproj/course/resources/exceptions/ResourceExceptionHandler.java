package com.nelcioneproj.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelcioneproj.course.services.exceptions.DatabaseException;
import com.nelcioneproj.course.services.exceptions.ResourceNotFoundException;

//tratamento personalizado da ResourceExceptionHandler
@ControllerAdvice // captura as exceções para faz tratamento 
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // fala que o método vai interceptar qualquer exception lançada
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resorce not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class) // fala que o método vai interceptar qualquer exception lançada
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
