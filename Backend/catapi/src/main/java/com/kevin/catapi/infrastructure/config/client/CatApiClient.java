package com.kevin.catapi.infrastructure.config.client;

import com.kevin.catapi.infrastructure.api.dto.BreedResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import com.kevin.catapi.infrastructure.api.dto.BreedImagesResponse;

@Component
public class CatApiClient {
    private final RestTemplate restTemplate;
    private final String API_URL = "https://api.thecatapi.com/v1";
    @Value("${thecatapi.key}")
    private String API_KEY;

    public CatApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para el controlador de Gatos
    public BreedResponse[] getBreeds() {
        // No uses getForObject, usa exchange para mandar la Key siempre
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key",API_KEY );
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                API_URL + "/breeds",
                HttpMethod.GET,
                entity,
                BreedResponse[].class
        ).getBody();
    }

    // NUEVO: Método para el controlador de Imágenes
    public BreedImagesResponse[] getImagesByBreed(String breedId) {
        try {

            String url = API_URL + "/images/search?breed_ids=" + breedId + "&limit=50";

            HttpHeaders headers = new HttpHeaders();
            headers.set("x-api-key", API_KEY);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            return restTemplate.exchange(url, HttpMethod.GET, entity, BreedImagesResponse[].class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return new BreedImagesResponse[0];
        }
    }
}
