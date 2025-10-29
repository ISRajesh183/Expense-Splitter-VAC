package com.ssn.esa.controller;

import com.ssn.esa.entity.Person;
import com.ssn.esa.dto.PersonDTO;
import com.ssn.esa.dto.AddBalanceDTO;
import com.ssn.esa.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for Person operations
 * Handles all HTTP requests related to persons and their balances
 */
@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    /**
     * Create a new person
     * POST /api/persons
     * @param personDTO the person data
     * @return created person with 201 status
     */
    @PostMapping
    public ResponseEntity<Person> createPerson(@Valid @RequestBody PersonDTO personDTO) {
        Person createdPerson = personService.createPerson(personDTO);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }
    
    /**
     * Get all persons
     * GET /api/persons
     * @return list of all persons with 200 status
     */
    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
    
    /**
     * Get person by ID
     * GET /api/persons/{id}
     * @param id the person ID
     * @return the person with 200 status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    
    /**
     * Update a person
     * PUT /api/persons/{id}
     * @param id the person ID
     * @param personDTO the updated person data
     * @return updated person with 200 status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable String id,
            @Valid @RequestBody PersonDTO personDTO) {
        Person updatedPerson = personService.updatePerson(id, personDTO);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }
    
    /**
     * Delete a person
     * DELETE /api/persons/{id}
     * @param id the person ID
     * @return 204 No Content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Add balance to person's account
     * POST /api/persons/{id}/add-balance
     * @param id the person ID
     * @param addBalanceDTO the amount to add
     * @return updated person with new balance and 200 status
     */
    @PostMapping("/{id}/add-balance")
    public ResponseEntity<Person> addBalance(
            @PathVariable String id,
            @Valid @RequestBody AddBalanceDTO addBalanceDTO) {
        Person updatedPerson = personService.addBalance(id, addBalanceDTO);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }
    
    /**
     * Get person's current balance
     * GET /api/persons/{id}/balance
     * @param id the person ID
     * @return balance information with 200 status
     */
    @GetMapping("/{id}/balance")
    public ResponseEntity<Map<String, Object>> getBalance(@PathVariable String id) {
        Double balance = personService.getBalance(id);
        
        Map<String, Object> response = new HashMap<>();
        response.put("personId", id);
        response.put("balance", balance);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}