package com.ssn.esa.repository;

import com.ssn.esa.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Person document
 * Provides CRUD operations for Person entities
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    
    /**
     * Find person by name
     * @param name the person's name
     * @return Optional containing the person if found
     */
    Optional<Person> findByName(String name);
    
    /**
     * Check if person exists by name
     * @param name the person's name
     * @return true if person exists
     */
    boolean existsByName(String name);
    boolean existsByEmail(String email);
    Optional<Person> findByEmail(String email);
}