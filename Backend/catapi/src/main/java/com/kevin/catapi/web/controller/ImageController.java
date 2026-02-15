package com.kevin.catapi.web.controller;
import com.kevin.catapi.infrastructure.config.client.CatApiClient;
import com.kevin.catapi.infrastructure.api.dto.BreedImagesResponse;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/images")
// En tu paquete de controladores (web.controller)
public class ImageController {

    private final CatApiClient catApiClient;

    public ImageController(CatApiClient catApiClient) {
        this.catApiClient = catApiClient;
    }

    @GetMapping("/imagesbybreedid")
    public BreedImagesResponse[] getImages(@RequestParam String breedId) {
        // Esto llama al método que acabamos de arreglar en el CatApiClient
        return catApiClient.getImagesByBreed(breedId);
    }
}
