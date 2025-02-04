package com.example.assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.assignment1", "controller", "service", "entity"})
public class Assignment1Application {
	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
	}
}
