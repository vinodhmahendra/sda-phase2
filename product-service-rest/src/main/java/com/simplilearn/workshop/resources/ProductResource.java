package com.simplilearn.workshop.resources;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.exceptions.ProductNotFoundException;
import com.simplilearn.workshop.model.Product;
import com.simplilearn.workshop.services.ProductService;

@RestController
public class ProductResource {

	@Autowired
	ProductService productService;
	
	@GetMapping(path = "/products")
	public List<Product> getAllTheProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping(path = "/products/{id}")
	public Product getProduct(@PathVariable Integer id) {
		Optional<Product> theProduct = productService.getProduct(id);
		if ( !theProduct.isPresent()) {
			throw new ProductNotFoundException("id - " + id);
		}
		return theProduct.get();
	}
	
	@PostMapping(path = "/products")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PutMapping(path = "/products/{id}")
	public void updateProduct(@PathVariable Integer id,@RequestBody Product product) {
		productService.updateProduct(id, product);
	}
	
	@DeleteMapping(path = "/products/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
	}
}
