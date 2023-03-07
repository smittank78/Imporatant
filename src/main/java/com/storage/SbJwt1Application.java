package com.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(info = @Info(
		title = "Spring Boot Individual Concepts Written In This Project ",
				description = "description : Written Several MEthods To Implement Sevral Operations",
		version = "3.0.1"
		))
public class SbJwt1Application {
	public static void main(String[] args) {
		SpringApplication.run(SbJwt1Application.class, args);
	}
}