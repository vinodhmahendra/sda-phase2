package com.simplilearn.workshop;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplilearn.workshop.model.Product;
import com.simplilearn.workshop.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceRestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceRestApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product();
		
		p1.setName("HP Laptop");
		p1.setPrice(new BigDecimal(67236.9));
		p1.setDateAdded(new Date());
		
		productRepository.save(p1);
		
		Product p2 = new Product();
		
		p2.setName("Acer Laptop");
		p2.setPrice(new BigDecimal(5657.9));
		p2.setDateAdded(new Date());
		
		productRepository.save(p2);
		
		Product p3 = new Product();
		
		p3.setName("Lenova Laptop");
		p3.setPrice(new BigDecimal(87987.9));
		p3.setDateAdded(new Date());
		
		productRepository.save(p3);
		
	}

}
