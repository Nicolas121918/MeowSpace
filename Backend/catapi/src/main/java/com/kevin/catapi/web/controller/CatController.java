package com.kevin.catapi.web.controller;

import com.kevin.catapi.application.usecase.GetBreedByIdUseCase;
import com.kevin.catapi.domain.model.Breed;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Collections;

@RestController
@RequestMapping("/cats")
public class CatController {

    private final GetBreedByIdUseCase getBreedByIdUseCase;

    // Inyectamos el Caso de Uso que consulta la API externa
    public CatController(GetBreedByIdUseCase getBreedByIdUseCase) {
        this.getBreedByIdUseCase = getBreedByIdUseCase;
    }

    @GetMapping("/search")
    public List<Breed> searchCats(@RequestParam("id") String id) {
        Breed breed = getBreedByIdUseCase.execute(id);

        if (breed != null && breed.getId() != null) {
            return List.of(breed);
        }
        return Collections.emptyList();
    }
}