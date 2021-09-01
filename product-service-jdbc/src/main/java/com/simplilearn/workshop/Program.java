package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simplilearn.workshop.config.ApplicationConfig;
import com.simplilearn.workshop.model.Product;
import com.simplilearn.workshop.repository.ProductRepository;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext container = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		ProductRepository productRepository = container.getBean(ProductRepository.class);
		
		List<Product> products = productRepository.findAll();
		
		for (Product eachElement : products) {
			System.out.println(eachElement);
		}
 	}

}
