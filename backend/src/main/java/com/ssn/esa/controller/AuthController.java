package com.ssn.esa.controller;

import com.ssn.esa.dto.PersonDTO;
import com.ssn.esa.dto.ResetPasswordDTO;
import com.ssn.esa.dto.LoginDTO;
import com.ssn.esa.entity.Person;
import com.ssn.esa.exception.ResourceNotFoundException;
import com.ssn.esa.repository.PersonRepository;
import com.ssn.esa.service.PersonService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for user authentication (register & login)
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    /**
     * Register a new user
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody PersonDTO personDTO) {
        // Check if email already exists
        if (personRepository.existsByEmail(personDTO.getEmail())) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Email already registered");
            return ResponseEntity.badRequest().body(response);
        }

        Person createdPerson = personService.createPerson(personDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User registered successfully");
        response.put("user", createdPerson);

        return ResponseEntity.ok(response);
    }

    /**
     * Login user by email & password
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        Person person = personRepository.findByEmail(email).orElse(null);

        if (person == null || !person.getPassword().equals(password)) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Invalid email or password");
            return ResponseEntity.status(401).body(response);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Login successful");
        response.put("user", person);
        return ResponseEntity.ok(response);
    }

    /**
     * Reset user password
     */
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordDTO resetPasswordDTO) {
        try {
            personService.resetPassword(resetPasswordDTO.getEmail(), resetPasswordDTO.getNewPassword());
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Password has been reset successfully.");
            return ResponseEntity.ok(response);
            
        } catch (ResourceNotFoundException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(404).body(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "An error occurred: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

}
