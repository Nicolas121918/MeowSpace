package com.kevin.catapi.infrastructure.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List; // importar la utilidad de lista

@JsonIgnoreProperties(ignoreUnknown = true)
public class BreedImagesResponse {
    private String id;
    private String url;
    private List<BreedResponse> breeds; // aqui entran los datos

    public BreedImagesResponse() {}

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public List<BreedResponse> getBreeds() { return breeds; }
    public void setBreeds(List<BreedResponse> breeds) { this.breeds = breeds; }
}