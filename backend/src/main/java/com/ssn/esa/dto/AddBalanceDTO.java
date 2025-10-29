package com.ssn.esa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Data Transfer Object for adding balance to a person's account
 */
public class AddBalanceDTO {
    
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;
    
    // Constructors
    public AddBalanceDTO() {}
    
    public AddBalanceDTO(Double amount) {
        this.amount = amount;
    }
    
    // Getters and Setters
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}