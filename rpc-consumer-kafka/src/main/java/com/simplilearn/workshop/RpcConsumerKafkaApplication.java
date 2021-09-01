package com.simplilearn.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class RpcConsumerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpcConsumerKafkaApplication.class, args);
	}

	
	@KafkaListener(topics = "test-topic",groupId = "foo")
	public void process(String message) {
		System.out.println(message);
	}
}
