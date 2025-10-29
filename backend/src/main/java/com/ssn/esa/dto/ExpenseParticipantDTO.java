package com.ssn.esa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Data Transfer Object for Expense Participant
 */
public class ExpenseParticipantDTO {
    
    @NotBlank(message = "Person ID is required")
    private String personId;
    
    @NotNull(message = "Share amount is required")
    @Positive(message = "Share amount must be positive")
    private Double shareAmount;
    
    // Constructors
    public ExpenseParticipantDTO() {}
    
    public ExpenseParticipantDTO(String personId, Double shareAmount) {
        this.personId = personId;
        this.shareAmount = shareAmount;
    }
    
    // Getters and Setters
    public String getPersonId() {
        return personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    
    public Double getShareAmount() {
        return shareAmount;
    }
    
    public void setShareAmount(Double shareAmount) {
        this.shareAmount = shareAmount;
    }
}