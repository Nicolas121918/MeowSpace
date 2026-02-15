package com.kevin.catapi.domain.repository;

import com.kevin.catapi.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
// AGREGAMOS: extends MongoRepository<User, String>
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username); 
}