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
        //  Llamamos al cliente que conecta con la API externa
        BreedResponse[] responses = catApiClient.getBreeds();

        if (responses == null) {
            return new ArrayList<>();
        }

        //  recorremos el array y hacemos insercion
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
        //obtenemos todos los gatos
        List<Breed> allBreeds = findAllBreeds();

        for (Breed breed : allBreeds) {
            // Comparamos el ID ignorando inconsistencias
            if (breed.getId().equalsIgnoreCase(id)) {
                return breed; 
            }
        }

        // null si no hay coincidencias
        return null;
    }
}