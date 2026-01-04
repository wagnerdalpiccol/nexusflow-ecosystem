package com.nexusflow.auth_service.domain.service;

import com.nexusflow.auth_service.domain.model.User;
import com.nexusflow.auth_service.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Injeção via construtor (melhor prática que @Autowired)
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // 1. Validar se o e-mail já existe
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Erro: Este e-mail já está registado!");
        }

        // 2. CIFRAR A SENHA ANTES DE SALVAR
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // 3. Salvar no banco
        return userRepository.save(user);
    }
}
