package com.ssn.esa.repository;

import com.ssn.esa.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for Expense document
 * Provides CRUD operations for Expense entities
 */
@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    
    /**
     * Find all expenses created by a specific person
     * @param paidBy the person ID
     * @return list of expenses
     */
    List<Expense> findByPaidBy(String paidBy);
    
    /**
     * Find expenses by category
     * @param category the expense category
     * @return list of expenses
     */
    List<Expense> findByCategory(String category);
    
    /**
     * Find expenses within date range
     * @param startDate start date
     * @param endDate end date
     * @return list of expenses
     */
    List<Expense> findByExpenseDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    /**
     * Find all expenses where a person is a participant
     * @param personId the person ID
     * @return list of expenses
     */
    @Query("{ 'participants.personId': ?0 }")
    List<Expense> findByParticipantPersonId(String personId);
    
    /**
     * Find all expenses where a person has due payments
     * @param personId the person ID
     * @return list of expenses with due payments
     */
    @Query("{ 'participants': { $elemMatch: { 'personId': ?0, 'isPaid': false } } }")
    List<Expense> findDueExpensesByPersonId(String personId);
    
    /**
     * Find all expenses where a person has paid
     * @param personId the person ID
     * @return list of expenses with paid status
     */
    @Query("{ 'participants': { $elemMatch: { 'personId': ?0, 'isPaid': true } } }")
    List<Expense> findPaidExpensesByPersonId(String personId);
}