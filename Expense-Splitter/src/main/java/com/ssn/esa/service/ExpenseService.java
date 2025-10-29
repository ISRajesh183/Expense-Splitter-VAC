package com.ssn.esa.service;

import com.ssn.esa.entity.*;
import com.ssn.esa.dto.*;
import com.ssn.esa.exception.*;
import com.ssn.esa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * Service class for Expense operations
 * Contains business logic for expense management and payment processing
 */
@Service
public class ExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private PersonService personService;
    
    /**
     * Create a new expense
     * @param expenseDTO the expense data
     * @return created expense
     */
    public Expense createExpense(ExpenseDTO expenseDTO) {
        // Validate that paidBy person exists
        Person paidByPerson = personRepository.findById(expenseDTO.getPaidBy())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + expenseDTO.getPaidBy()));
        
        // Validate that all participant persons exist
        List<ExpenseParticipant> participants = new ArrayList<>();
        double totalShares = 0.0;
        
        for (ExpenseParticipantDTO participantDTO : expenseDTO.getParticipants()) {
            Person person = personRepository.findById(participantDTO.getPersonId())
                    .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + participantDTO.getPersonId()));
            
            ExpenseParticipant participant = new ExpenseParticipant(
                person.getId(),
                person.getName(),
                participantDTO.getShareAmount()
            );
            
            participants.add(participant);
            totalShares += participantDTO.getShareAmount();
        }
        
        // Validate that total shares match total amount
        if (Math.abs(totalShares - expenseDTO.getTotalAmount()) > 0.01) {
            throw new IllegalArgumentException(
                "Sum of participant shares (" + totalShares + ") must equal total amount (" + expenseDTO.getTotalAmount() + ")"
            );
        }
        
        Expense expense = new Expense();
        expense.setDescription(expenseDTO.getDescription());
        expense.setTotalAmount(expenseDTO.getTotalAmount());
        expense.setPaidBy(expenseDTO.getPaidBy());
        expense.setPaidByName(paidByPerson.getName());
        expense.setParticipants(participants);
        expense.setCategory(expenseDTO.getCategory());
        
        if (expenseDTO.getExpenseDate() != null) {
            expense.setExpenseDate(expenseDTO.getExpenseDate());
        }
        
        return expenseRepository.save(expense);
    }
    
    /**
     * Get all expenses
     * @return list of all expenses
     */
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    
    /**
     * Get expense by ID
     * @param id the expense ID
     * @return the expense
     */
    public Expense getExpenseById(String id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
    }
    
    /**
     * Update an expense
     * @param id the expense ID
     * @param expenseDTO the updated expense data
     * @return updated expense
     */
    public Expense updateExpense(String id, ExpenseDTO expenseDTO) {
        Expense expense = getExpenseById(id);
        
        // Validate that paidBy person exists
        Person paidByPerson = personRepository.findById(expenseDTO.getPaidBy())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + expenseDTO.getPaidBy()));
        
        // Validate that all participant persons exist
        List<ExpenseParticipant> participants = new ArrayList<>();
        double totalShares = 0.0;
        
        for (ExpenseParticipantDTO participantDTO : expenseDTO.getParticipants()) {
            Person person = personRepository.findById(participantDTO.getPersonId())
                    .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + participantDTO.getPersonId()));
            
            ExpenseParticipant participant = new ExpenseParticipant(
                person.getId(),
                person.getName(),
                participantDTO.getShareAmount()
            );
            
            participants.add(participant);
            totalShares += participantDTO.getShareAmount();
        }
        
        // Validate that total shares match total amount
        if (Math.abs(totalShares - expenseDTO.getTotalAmount()) > 0.01) {
            throw new IllegalArgumentException(
                "Sum of participant shares (" + totalShares + ") must equal total amount (" + expenseDTO.getTotalAmount() + ")"
            );
        }
        
        expense.setDescription(expenseDTO.getDescription());
        expense.setTotalAmount(expenseDTO.getTotalAmount());
        expense.setPaidBy(expenseDTO.getPaidBy());
        expense.setPaidByName(paidByPerson.getName());
        expense.setParticipants(participants);
        expense.setCategory(expenseDTO.getCategory());
        
        if (expenseDTO.getExpenseDate() != null) {
            expense.setExpenseDate(expenseDTO.getExpenseDate());
        }
        
        return expenseRepository.save(expense);
    }
    
    /**
     * Delete an expense
     * @param id the expense ID
     */
    public void deleteExpense(String id) {
        Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
    }
    
    /**
     * Get all due expenses for a person
     * @param personId the person ID
     * @return list of expenses with due payments
     */
    public List<Expense> getDueExpenses(String personId) {
        // Verify person exists
        personService.getPersonById(personId);
        
        return expenseRepository.findDueExpensesByPersonId(personId);
    }
    
    /**
     * Get all paid expenses for a person
     * @param personId the person ID
     * @return list of expenses with paid status
     */
    public List<Expense> getPaidExpenses(String personId) {
        // Verify person exists
        personService.getPersonById(personId);
        
        return expenseRepository.findPaidExpensesByPersonId(personId);
    }
    
    /**
     * Get all expenses created by a person
     * @param personId the person ID
     * @return list of expenses
     */
    public List<Expense> getExpensesByCreator(String personId) {
        return expenseRepository.findByPaidBy(personId);
    }
    
    /**
     * Get expenses by category
     * @param category the category
     * @return list of expenses
     */
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }
    
    /**
     * Pay an expense share
     * Deducts the share amount from person's balance and marks expense as paid
     * @param expenseId the expense ID
     * @param personId the person ID who is paying
     * @return payment response with details
     */
    @Transactional
    public PaymentResponseDTO payExpense(String expenseId, String personId) {
        // Get expense
        Expense expense = getExpenseById(expenseId);
        
        // Get person
        Person person = personService.getPersonById(personId);
        
        // Find participant in expense
        ExpenseParticipant participant = expense.getParticipants().stream()
                .filter(p -> p.getPersonId().equals(personId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                    "Person with id " + personId + " is not a participant in this expense"
                ));
        
        // Check if already paid
        if (participant.getIsPaid()) {
            PaymentResponseDTO response = new PaymentResponseDTO(
                "Expense share already paid",
                false
            );
            return response;
        }
        
        // Check if person has sufficient balance
        Double shareAmount = participant.getShareAmount();
        Double currentBalance = person.getBalance();
        
        if (currentBalance < shareAmount) {
            throw new InsufficientBalanceException(
                "Insufficient balance. Required: " + shareAmount + ", Available: " + currentBalance
            );
        }
        
        // Deduct amount from person's balance
        person = personService.deductBalance(personId, shareAmount);
        
        // Mark participant as paid
        participant.setIsPaid(true);
        participant.setPaidAt(LocalDateTime.now());
        
        // Save expense
        expenseRepository.save(expense);
        
        // Create response
        PaymentResponseDTO response = new PaymentResponseDTO(
            "Payment successful",
            true
        );
        response.setExpenseId(expenseId);
        response.setPersonId(personId);
        response.setAmountPaid(shareAmount);
        response.setRemainingBalance(person.getBalance());
        
        return response;
    }
    
    /**
     * Get total due amount for a person
     * @param personId the person ID
     * @return total due amount
     */
    public Double getTotalDueAmount(String personId) {
        List<Expense> dueExpenses = getDueExpenses(personId);
        
        double totalDue = 0.0;
        for (Expense expense : dueExpenses) {
            for (ExpenseParticipant participant : expense.getParticipants()) {
                if (participant.getPersonId().equals(personId) && !participant.getIsPaid()) {
                    totalDue += participant.getShareAmount();
                }
            }
        }
        
        return totalDue;
    }
    
    /**
     * Get total paid amount by a person
     * @param personId the person ID
     * @return total paid amount
     */
    public Double getTotalPaidAmount(String personId) {
        List<Expense> paidExpenses = getPaidExpenses(personId);
        
        double totalPaid = 0.0;
        for (Expense expense : paidExpenses) {
            for (ExpenseParticipant participant : expense.getParticipants()) {
                if (participant.getPersonId().equals(personId) && participant.getIsPaid()) {
                    totalPaid += participant.getShareAmount();
                }
            }
        }
        
        return totalPaid;
    }
}