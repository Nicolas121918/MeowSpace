package com.kevin.catapi.infrastructure.repository;

import com.kevin.catapi.domain.model.Breed;
import com.kevin.catapi.infrastructure.api.dto.BreedResponse;
import com.kevin.catapi.domain.repository.BreedRepository;
import com.kevin.catapi.infrastructure.config.client.CatApiClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BreedRepositoryImpl implements BreedRepository {

    private final CatApiClient catApiClient;

    public BreedRepositoryImpl(CatApiClient catApiClient) {
        this.catApiClient = catApiClient;
    }

    @Override
    public List<Breed> findAllBreeds() {
        // 1. Llamamos al cliente que conecta con la API externa
        BreedResponse[] responses = catApiClient.getBreeds();

        if (responses == null) {
            return new ArrayList<>();
        }

        // 2. Convertimos (Mapeamos) de BreedResponse (Infraestructura) a Breed (Dominio)
        List<Breed> breeds = new ArrayList<>();
        for (BreedResponse response : responses) {
            breeds.add(new Breed(
                    response.getId(),
                    response.getName(),
                    response.getOrigin(),
                    response.getDescription()
            ));
        }

        return breeds;
    }

    @Override
    public Breed findById(String id) {
        // 1. Reutilizamos el método de arriba para obtener todos los gatos
        List<Breed> allBreeds = findAllBreeds();

        // 2. Buscamos manualmente el que coincida con el ID
        for (Breed breed : allBreeds) {
            // Comparamos el ID ignorando mayúsculas/minúsculas por seguridad
            if (breed.getId().equalsIgnoreCase(id)) {
                return breed; // Si lo encuentra, lo devuelve inmediatamente
            }
        }

        // 3. Si recorre toda la lista y no encuentra nada, devuelve null
        return null;
    }
}