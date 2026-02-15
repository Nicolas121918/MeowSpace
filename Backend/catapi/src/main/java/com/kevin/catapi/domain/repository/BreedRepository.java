package com.kevin.catapi.domain.repository;
import com.kevin.catapi.domain.model.Breed;
import java.util.List;
public interface BreedRepository {
    List<Breed> findAllBreeds();
    // Nueva promesa: "Si me das un ID, te devuelvo esa raza"
    Breed findById(String id);
}
