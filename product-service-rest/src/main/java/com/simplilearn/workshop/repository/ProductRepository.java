package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
