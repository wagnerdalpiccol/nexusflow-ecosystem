package com.nexusflow.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		System.setProperty("user.dir", "..");
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
