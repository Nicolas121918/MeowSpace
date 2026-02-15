package com.kevin.catapi.application.usecase;

import com.kevin.catapi.domain.model.Breed;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetBreedByIdUseCase {

    private final RestTemplate restTemplate;

    public GetBreedByIdUseCase() {
        this.restTemplate = new RestTemplate();
    }

    public Breed execute(String id) {
        // Consultamos directamente a The Cat API
        String url = "https://api.thecatapi.com/v1/breeds/" + id;
        
        try {
            // Jackson usará el constructor vacío de Breed para llenar los datos
            return restTemplate.getForObject(url, Breed.class);
        } catch (Exception e) {
            System.err.println("Error al consultar la API: " + e.getMessage());
            return null;
        }
    }
}