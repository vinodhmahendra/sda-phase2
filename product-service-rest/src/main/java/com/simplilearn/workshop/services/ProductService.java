package com.simplilearn.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Product;
import com.simplilearn.workshop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Optional<Product> getProduct(Integer id) {
		return productRepository.findById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void updateProduct(Integer id , Product product) {
		if ( productRepository.findById(id).isPresent()) {
			Product loadedProduct = productRepository.findById(id).get();
			loadedProduct.setId(id);
			loadedProduct.setName(product.getName());
			loadedProduct.setPrice(product.getPrice());
			loadedProduct.setDateAdded(product.getDateAdded());
			
			productRepository.save(loadedProduct);
		}
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
}
