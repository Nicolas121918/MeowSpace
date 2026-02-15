package com.kevin.catapi.config;


import com.kevin.catapi.application.usecase.GetBreedsUseCase;
import com.kevin.catapi.domain.repository.BreedRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetBreedsUseCase getBreedsUseCase(BreedRepository breedRepository) {
        return new GetBreedsUseCase(breedRepository);
    }
}