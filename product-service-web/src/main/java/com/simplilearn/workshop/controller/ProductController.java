package com.simplilearn.workshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.Product;

@Controller
public class ProductController {
	
	private static final String BASE_URL ="http://localhost:8080/products";

	private RestTemplate restTemplate;
	
	@Autowired
	public ProductController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	
	@PostMapping(path = "/products/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Product theProduct) {
		ModelAndView modelAndview = new ModelAndView("redirect:/products/list");
		restTemplate.postForObject(BASE_URL, theProduct, Product.class);
		return modelAndview;
	}
	
	
	@GetMapping(path = "/products/showFormForAdd")
	public ModelAndView showFormForAddProduct() {
		ModelAndView modelAndView = new ModelAndView("product-form");
		Product product = new Product();
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	
	@GetMapping(path = "/products/delete")
	public ModelAndView deleteProduct(@RequestParam("productId") Integer theId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("theId", theId);
		restTemplate.delete(BASE_URL+"/{theId}",params);
		
		ResponseEntity<List<Product>> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>() {
		});
		
		List<Product> products = responseEntity.getBody();
		
		ModelAndView modelAndView = new ModelAndView("list-products");
		modelAndView.addObject("products",products);
		
		return modelAndView;
	}
	@GetMapping(path = "/products/showFormForUpdate")
	public ModelAndView showFormForUpdate(@RequestParam("productId") Integer theId,Model theModel) {
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("theId", theId);
		Product theProduct = restTemplate.getForObject(BASE_URL+"/{theId}", Product.class,params);
		theModel.addAttribute("product", theProduct);
		return new ModelAndView("product-form");
	}

	@GetMapping(path = "/products/list")
	public ModelAndView listOfProducts() {
		ResponseEntity<List<Product>> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>() {
		});
		
		List<Product> products = responseEntity.getBody();
		
		ModelAndView modelAndView = new ModelAndView("list-products");
		modelAndView.addObject("products",products);
		
		return modelAndView;
	}
}
