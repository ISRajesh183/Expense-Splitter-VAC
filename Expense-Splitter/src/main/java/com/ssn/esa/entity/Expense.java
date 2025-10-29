package com.ssn.esa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * Expense Document - Represents an expense with participant payment tracking
 */
@Document(collection = "expenses")
public class Expense {
    
    @Id
    private String id;
    
    @NotBlank(message = "Description is required")
    private String description;
    
    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    private Double totalAmount;
    
    @NotBlank(message = "Paid by person ID is required")
    private String paidBy; // Person ID who created/paid the expense initially
    
    private String paidByName; // Denormalized for easier display
    
    @NotEmpty(message = "Participants list cannot be empty")
    private List<ExpenseParticipant> participants; // List of people who need to pay their share
    
    private String category; // Optional: Food, Transport, Entertainment, etc.
    
    private LocalDateTime expenseDate;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    // Constructors
    public Expense() {
        this.participants = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.expenseDate = LocalDateTime.now();
    }
    
    public Expense(String description, Double totalAmount, String paidBy, String paidByName) {
        this.description = description;
        this.totalAmount = totalAmount;
        this.paidBy = paidBy;
        this.paidByName = paidByName;
        this.participants = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.expenseDate = LocalDateTime.now();
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }
    
    public Double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPaidBy() {
        return paidBy;
    }
    
    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPaidByName() {
        return paidByName;
    }
    
    public void setPaidByName(String paidByName) {
        this.paidByName = paidByName;
    }
    
    public List<ExpenseParticipant> getParticipants() {
        return participants;
    }
    
    public void setParticipants(List<ExpenseParticipant> participants) {
        this.participants = participants;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }
    
    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}