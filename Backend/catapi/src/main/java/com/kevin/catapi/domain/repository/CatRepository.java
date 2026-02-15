package com.kevin.catapi.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kevin.catapi.domain.model.Breed;

public interface CatRepository extends MongoRepository<Breed, String> {
    List<Breed> findByIdContainingIgnoreCase(String id);
}
