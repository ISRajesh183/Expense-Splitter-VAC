package com.ssn.esa.service;

import com.ssn.esa.entity.Person;
import com.ssn.esa.dto.PersonDTO;
import com.ssn.esa.dto.AddBalanceDTO;
import com.ssn.esa.exception.ResourceNotFoundException;
import com.ssn.esa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Person operations
 * Contains business logic for person management and balance operations
 */
@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    /**
     * Create a new person
     * @param personDTO the person data
     * @return created person
     */
    public Person createPerson(PersonDTO personDTO) {
        // Check if person with same name already exists
        if (personRepository.existsByName(personDTO.getName())) {
            throw new IllegalArgumentException("Person with name '" + personDTO.getName() + "' already exists");
        }
        
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        person.setPassword(personDTO.getPassword());
        person.setBalance(0.0); // Initialize balance to 0
        
        return personRepository.save(person);
    }
    
    /**
     * Get all persons
     * @return list of all persons
     */
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    /**
     * Get person by ID
     * @param id the person ID
     * @return the person
     */
    public Person getPersonById(String id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));
    }
    
    /**
     * Update a person
     * @param id the person ID
     * @param personDTO the updated person data
     * @return updated person
     */
    public Person updatePerson(String id, PersonDTO personDTO) {
        Person person = getPersonById(id);
        
        // Check if new name conflicts with existing person
        if (!person.getName().equals(personDTO.getName()) && 
            personRepository.existsByName(personDTO.getName())) {
            throw new IllegalArgumentException("Person with name '" + personDTO.getName() + "' already exists");
        }
        
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        person.setPassword(personDTO.getPassword());
        return personRepository.save(person);
    }
    
    /**
     * Delete a person
     * @param id the person ID
     */
    public void deletePerson(String id) {
        Person person = getPersonById(id);
        personRepository.delete(person);
    }
    
    /**
     * Add money to person's balance
     * @param id the person ID
     * @param addBalanceDTO the amount to add
     * @return updated person with new balance
     */
    public Person addBalance(String id, AddBalanceDTO addBalanceDTO) {
        Person person = getPersonById(id);
        
        Double currentBalance = person.getBalance();
        Double newBalance = currentBalance + addBalanceDTO.getAmount();
        
        person.setBalance(newBalance);
        
        return personRepository.save(person);
    }
    
    /**
     * Get person's current balance
     * @param id the person ID
     * @return current balance
     */
    public Double getBalance(String id) {
        Person person = getPersonById(id);
        return person.getBalance();
    }
    
    /**
     * Check if person exists by ID
     * @param id the person ID
     * @return true if exists
     */
    public boolean existsById(String id) {
        return personRepository.existsById(id);
    }
    
    /**
     * Deduct amount from person's balance
     * Used internally when paying expenses
     * @param id the person ID
     * @param amount the amount to deduct
     * @return updated person
     */
    public Person deductBalance(String id, Double amount) {
        Person person = getPersonById(id);
        
        Double currentBalance = person.getBalance();
        Double newBalance = currentBalance - amount;
        
        // Balance should never go negative in this system
        if (newBalance < 0) {
            newBalance = 0.0;
        }
        
        person.setBalance(newBalance);
        
        return personRepository.save(person);
    }
}