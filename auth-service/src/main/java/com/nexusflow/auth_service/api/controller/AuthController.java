package com.nexusflow.auth_service.api.controller;

import com.nexusflow.auth_service.api.dto.UserRegistrationRequest;
import com.nexusflow.auth_service.domain.model.User;
import com.nexusflow.auth_service.domain.service.UserService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationRequest request) {
        try {
            // Convertendo DTO para Entidade (Simples para o teste)
            User newUser = new User();
            newUser.setName(request.name());
            newUser.setEmail(request.email());
            newUser.setPassword(request.password());

            User savedUser = userService.registerUser(newUser);
            
            // Retornamos o usuário salvo, mas limpamos a senha na resposta por segurança
            savedUser.setPassword("**** PROTECTED ****");
            return ResponseEntity.ok(savedUser);
            
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}