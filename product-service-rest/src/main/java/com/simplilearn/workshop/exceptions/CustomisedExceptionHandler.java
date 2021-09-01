package com.simplilearn.workshop.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.simplilearn.workshop.model.Product;

@RestControllerAdvice
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Product> handleAllExceptions(Exception ex,WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Product> handleProductNotFoundException(Exception ex,WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}

}
