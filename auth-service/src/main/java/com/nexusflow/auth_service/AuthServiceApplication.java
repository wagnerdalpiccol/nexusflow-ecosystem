package com.nexusflow.auth_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nexusflow.auth_service.domain.model.User;
import com.nexusflow.auth_service.domain.repository.UserRepository;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		System.setProperty("user.dir", "..");
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
	/*
	 * @Bean CommandLineRunner initDatabase(UserRepository userRepository) { return
	 * args -> { User testUser = new User(); testUser.setName("Wagner");
	 * testUser.setEmail("wagner@teste.com"); testUser.setPassword("123456");
	 * 
	 * userRepository.save(testUser);
	 * System.out.println(">>> USUÁRIO DE TESTE SALVO COM SUCESSO!"); }; }
	 */

}
