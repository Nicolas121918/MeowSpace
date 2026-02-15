package com.kevin.catapi.web.controller;

import com.kevin.catapi.application.usecase.GetBreedByIdUseCase;
import com.kevin.catapi.application.usecase.GetBreedsUseCase;
import com.kevin.catapi.domain.model.Breed;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BreedController {

    private final GetBreedsUseCase getBreedsUseCase;
    private final GetBreedByIdUseCase getBreedByIdUseCase;

    public BreedController(GetBreedsUseCase getBreedsUseCase, GetBreedByIdUseCase getBreedByIdUseCase) {
        this.getBreedsUseCase = getBreedsUseCase;
        this.getBreedByIdUseCase = getBreedByIdUseCase;
    }

    @GetMapping("/breeds")
    public List<Breed> getBreeds() {
        return getBreedsUseCase.execute();
    }

    @GetMapping("/breeds/{breed_id}")
    public Breed getbreedsbyid(@PathVariable("breed_id") String breed_Id) {
        return getBreedByIdUseCase.execute(breed_Id);
    }
}