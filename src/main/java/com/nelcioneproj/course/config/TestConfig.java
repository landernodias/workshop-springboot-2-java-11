package com.nelcioneproj.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelcioneproj.course.entities.Order;
import com.nelcioneproj.course.entities.User;
import com.nelcioneproj.course.entities.enums.OrderStatus;
import com.nelcioneproj.course.repositories.OrderRepository;
import com.nelcioneproj.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //instancia o banco de dados
	
	//injeção de dependencia
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	//executa quando a aplicação é iniciada
	@Override
	public void run(String... args) throws Exception {//seeding do banco de dados
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
		
		//date: ISO 8601 : padrão UTC TimeZone GMT
		Order o1 = new Order(null, Instant.parse("2022-06-29T16:05:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-07-29T03:41:19Z"), OrderStatus.WATTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-07-29T21:21:14Z"), OrderStatus.WATTING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
	
}
