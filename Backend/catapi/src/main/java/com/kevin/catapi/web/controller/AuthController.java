package com.kevin.catapi.web.controller;

import com.kevin.catapi.application.usecase.LoginUserUseCase;
import com.kevin.catapi.application.usecase.RegisterUserUseCase; 
import com.kevin.catapi.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUserUseCase loginUserUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    // Inyectamos ambos casos de uso en el constructor
    public AuthController(LoginUserUseCase loginUserUseCase, RegisterUserUseCase registerUserUseCase) {
        this.loginUserUseCase = loginUserUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        boolean isAuthenticated = loginUserUseCase.execute(username, password);

        if (isAuthenticated) {
            return ResponseEntity.ok(Map.of(
                    "message", "Login exitoso",
                    "username", username));
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            // Usamos el caso de uso para guardar en Atlas
            User registeredUser = registerUserUseCase.execute(user);
            return ResponseEntity.ok(Map.of(
                    "message", "Usuario registrado exitosamente en Atlas",
                    "id", registeredUser.getId(),
                    "username", registeredUser.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Map.of("error", "Error al registrar: " + e.getMessage()));
        }
    }
}