package com.ssn.esa.dto;

/**
 * Data Transfer Object for payment response
 */
public class PaymentResponseDTO {
    
    private String message;
    private String expenseId;
    private String personId;
    private Double amountPaid;
    private Double remainingBalance;
    private Boolean success;
    
    // Constructors
    public PaymentResponseDTO() {}
    
    public PaymentResponseDTO(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }
    
    // Getters and Setters
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getExpenseId() {
        return expenseId;
    }
    
    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }
    
    public String getPersonId() {
        return personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    
    public Double getAmountPaid() {
        return amountPaid;
    }
    
    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    public Double getRemainingBalance() {
        return remainingBalance;
    }
    
    public void setRemainingBalance(Double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}