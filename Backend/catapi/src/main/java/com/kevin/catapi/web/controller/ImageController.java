package com.kevin.catapi.web.controller;

import com.kevin.catapi.infrastructure.config.client.CatApiClient;
import com.kevin.catapi.infrastructure.api.dto.BreedImagesResponse;
import com.kevin.catapi.infrastructure.api.dto.BreedResponse; // Asegúrate de tener este DTO
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    private final CatApiClient catApiClient;

    public ImageController(CatApiClient catApiClient) {
        this.catApiClient = catApiClient;
    }

    @GetMapping("/galeria")
    public BreedImagesResponse[] obtenerGaleria() {
        return catApiClient.GetImagesLimit();
    }

    @GetMapping("/imagesbybreedid")
    public BreedImagesResponse[] getImages(@RequestParam String breedId) {
        return catApiClient.getImagesByBreed(breedId);
    }

    @GetMapping("/all-breeds")
    public BreedResponse[] getAllBreeds() {
        return catApiClient.getBreeds();
    }
}