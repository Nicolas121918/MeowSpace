package com.kevin.catapi.application.usecase;

import com.kevin.catapi.domain.model.User;
import com.kevin.catapi.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginUserUseCase {
    private final UserRepository userRepository;

    public LoginUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        // verifica si existe el usuario y la contraseña coincide
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}