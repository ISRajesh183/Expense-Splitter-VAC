package com.ssn.esa.controller;

import com.ssn.esa.entity.Expense;
import com.ssn.esa.dto.ExpenseDTO;
import com.ssn.esa.dto.PaymentResponseDTO;
import com.ssn.esa.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for Expense operations
 * Handles all HTTP requests related to expenses and payments
 */
@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {
    
    @Autowired
    private ExpenseService expenseService;
    
    /**
     * Create a new expense
     * POST /api/expenses
     * @param expenseDTO the expense data
     * @return created expense with 201 status
     */
    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        Expense createdExpense = expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
    }
    
    /**
     * Get all expenses
     * GET /api/expenses
     * @return list of all expenses with 200 status
     */
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
    
    /**
     * Get expense by ID
     * GET /api/expenses/{id}
     * @param id the expense ID
     * @return the expense with 200 status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable String id) {
        Expense expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }
    
    /**
     * Update an expense
     * PUT /api/expenses/{id}
     * @param id the expense ID
     * @param expenseDTO the updated expense data
     * @return updated expense with 200 status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
            @PathVariable String id,
            @Valid @RequestBody ExpenseDTO expenseDTO) {
        Expense updatedExpense = expenseService.updateExpense(id, expenseDTO);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }
    
    /**
     * Delete an expense
     * DELETE /api/expenses/{id}
     * @param id the expense ID
     * @return 204 No Content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Get due expenses for a person
     * GET /api/expenses/person/{personId}/due
     * @param personId the person ID
     * @return list of due expenses with 200 status
     */
    @GetMapping("/person/{personId}/due")
    public ResponseEntity<List<Expense>> getDueExpenses(@PathVariable String personId) {
        List<Expense> dueExpenses = expenseService.getDueExpenses(personId);
        return new ResponseEntity<>(dueExpenses, HttpStatus.OK);
    }
    
    /**
     * Get paid expenses for a person
     * GET /api/expenses/person/{personId}/paid
     * @param personId the person ID
     * @return list of paid expenses with 200 status
     */
    @GetMapping("/person/{personId}/paid")
    public ResponseEntity<List<Expense>> getPaidExpenses(@PathVariable String personId) {
        List<Expense> paidExpenses = expenseService.getPaidExpenses(personId);
        return new ResponseEntity<>(paidExpenses, HttpStatus.OK);
    }
    
    /**
     * Get expenses created by a person
     * GET /api/expenses/creator/{personId}
     * @param personId the person ID
     * @return list of expenses with 200 status
     */
    @GetMapping("/creator/{personId}")
    public ResponseEntity<List<Expense>> getExpensesByCreator(@PathVariable String personId) {
        List<Expense> expenses = expenseService.getExpensesByCreator(personId);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
    
    /**
     * Get expenses by category
     * GET /api/expenses/category/{category}
     * @param category the category
     * @return list of expenses with 200 status
     */
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@PathVariable String category) {
        List<Expense> expenses = expenseService.getExpensesByCategory(category);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
    
    /**
     * Pay an expense share
     * POST /api/expenses/{expenseId}/pay/{personId}
     * @param expenseId the expense ID
     * @param personId the person ID who is paying
     * @return payment response with 200 status
     */
    @PostMapping("/{expenseId}/pay/{personId}")
    public ResponseEntity<PaymentResponseDTO> payExpense(
            @PathVariable String expenseId,
            @PathVariable String personId) {
        PaymentResponseDTO response = expenseService.payExpense(expenseId, personId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    /**
     * Get total due amount for a person
     * GET /api/expenses/person/{personId}/total-due
     * @param personId the person ID
     * @return total due amount with 200 status
     */
    @GetMapping("/person/{personId}/total-due")
    public ResponseEntity<Map<String, Object>> getTotalDueAmount(@PathVariable String personId) {
        Double totalDue = expenseService.getTotalDueAmount(personId);
        
        Map<String, Object> response = new HashMap<>();
        response.put("personId", personId);
        response.put("totalDue", totalDue);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    /**
     * Get total paid amount by a person
     * GET /api/expenses/person/{personId}/total-paid
     * @param personId the person ID
     * @return total paid amount with 200 status
     */
    @GetMapping("/person/{personId}/total-paid")
    public ResponseEntity<Map<String, Object>> getTotalPaidAmount(@PathVariable String personId) {
        Double totalPaid = expenseService.getTotalPaidAmount(personId);
        
        Map<String, Object> response = new HashMap<>();
        response.put("personId", personId);
        response.put("totalPaid", totalPaid);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get ALL expenses where a person is a participant
     * GET /api/expenses/person/{personId}/all
     * @param personId the person ID
     * @return list of all expenses with 200 status
     */
    @GetMapping("/person/{personId}/all")
    public ResponseEntity<List<Expense>> getAllExpensesForPerson(@PathVariable String personId) {
        List<Expense> allExpenses = expenseService.getAllExpensesForPerson(personId);
        return new ResponseEntity<>(allExpenses, HttpStatus.OK);
    }
}