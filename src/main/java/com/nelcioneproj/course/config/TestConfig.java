package com.nelcioneproj.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelcioneproj.course.entities.Category;
import com.nelcioneproj.course.entities.Order;
import com.nelcioneproj.course.entities.OrderItem;
import com.nelcioneproj.course.entities.Payment;
import com.nelcioneproj.course.entities.Product;
import com.nelcioneproj.course.entities.User;
import com.nelcioneproj.course.entities.enums.OrderStatus;
import com.nelcioneproj.course.repositories.CategoryRepository;
import com.nelcioneproj.course.repositories.OrderItemRepository;
import com.nelcioneproj.course.repositories.OrderRepository;
import com.nelcioneproj.course.repositories.ProductRepository;
import com.nelcioneproj.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //instancia o banco de dados
	
	//injeção de dependencia
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	//executa quando a aplicação é iniciada
	@Override
	public void run(String... args) throws Exception {//seeding do banco de dados
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetor", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "NUlla eu imperdiet purus. maecanas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortot, at mollis", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dumies", "Cras fringella canvallis sem vel faucibus", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		//adcionas os produtos a uma categoria
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
				
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
		
		//date: ISO 8601 : padrão UTC TimeZone GMT
		Order o1 = new Order(null, Instant.parse("2022-06-29T16:05:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-07-29T03:41:19Z"), OrderStatus.WATTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-07-29T21:21:14Z"), OrderStatus.WATTING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2022-06-29T18:05:07Z") , o1);
		
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}
	
	
	
}
