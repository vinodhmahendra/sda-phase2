package com.simplilearn.workshop.repository;

import java.util.List;

import com.simplilearn.workshop.model.Product;


public interface ProductRepository {
	
	public List<Product> findAll();
	
}
