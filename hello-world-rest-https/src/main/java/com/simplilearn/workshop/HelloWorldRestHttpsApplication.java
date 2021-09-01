package com.simplilearn.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldRestHttpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldRestHttpsApplication.class, args);
	}
	
	

}
