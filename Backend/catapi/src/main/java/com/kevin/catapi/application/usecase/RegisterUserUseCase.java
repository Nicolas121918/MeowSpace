package com.kevin.catapi.application.usecase;

import com.kevin.catapi.domain.model.User;
import com.kevin.catapi.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCase {
    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.save(user);
    }
}