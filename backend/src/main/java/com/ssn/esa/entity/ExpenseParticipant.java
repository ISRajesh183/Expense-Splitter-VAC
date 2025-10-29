package com.ssn.esa.entity;

import java.time.LocalDateTime;

/**
 * Embedded document representing a participant's share in an expense
 * Tracks individual payment status for each participant
 */
public class ExpenseParticipant {
    
    private String personId;
    private String personName; // Denormalized for easier display
    private Double shareAmount;
    private Boolean isPaid;
    private LocalDateTime paidAt;
    
    // Constructors
    public ExpenseParticipant() {
        this.isPaid = false;
    }
    
    public ExpenseParticipant(String personId, String personName, Double shareAmount) {
        this.personId = personId;
        this.personName = personName;
        this.shareAmount = shareAmount;
        this.isPaid = false;
    }
    
    // Getters and Setters
    public String getPersonId() {
        return personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    
    public String getPersonName() {
        return personName;
    }
    
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    
    public Double getShareAmount() {
        return shareAmount;
    }
    
    public void setShareAmount(Double shareAmount) {
        this.shareAmount = shareAmount;
    }
    
    public Boolean getIsPaid() {
        return isPaid;
    }
    
    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    public LocalDateTime getPaidAt() {
        return paidAt;
    }
    
    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }
}