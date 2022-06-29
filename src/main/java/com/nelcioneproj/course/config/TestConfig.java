package com.nelcioneproj.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelcioneproj.course.entities.User;
import com.nelcioneproj.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //instancia o banco de dados
	
	//injeção de dependencia
	@Autowired
	private UserRepository userRepository;

	//executa quando a aplicação é iniciada
	@Override
	public void run(String... args) throws Exception {//seeding do banco de dados
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	
}
