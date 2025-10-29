package com.ssn.esa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object for Expense
 */
public class ExpenseDTO {
    
    @NotBlank(message = "Description is required")
    private String description;
    
    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    private Double totalAmount;
    
    @NotBlank(message = "Paid by person ID is required")
    private String paidBy;
    
    @NotEmpty(message = "Participants list cannot be empty")
    @Valid
    private List<ExpenseParticipantDTO> participants;
    
    private String category;
    
    private LocalDateTime expenseDate;
    
    // Constructors
    public ExpenseDTO() {}
    
    public ExpenseDTO(String description, Double totalAmount, String paidBy, List<ExpenseParticipantDTO> participants) {
        this.description = description;
        this.totalAmount = totalAmount;
        this.paidBy = paidBy;
        this.participants = participants;
    }
    
    // Getters and Setters
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getPaidBy() {
        return paidBy;
    }
    
    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }
    
    public List<ExpenseParticipantDTO> getParticipants() {
        return participants;
    }
    
    public void setParticipants(List<ExpenseParticipantDTO> participants) {
        this.participants = participants;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }
    
    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }
}