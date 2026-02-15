package com.kevin.catapi.application.usecase;

import com.kevin.catapi.domain.model.Breed;
import com.kevin.catapi.domain.repository.BreedRepository;
import java.util.List;
public class GetBreedsUseCase {
    private final BreedRepository breedRepository;
    public GetBreedsUseCase(BreedRepository breedRepository){
        this.breedRepository = breedRepository;
    }
    public List<Breed> execute(){
        return breedRepository.findAllBreeds();
    }
}
