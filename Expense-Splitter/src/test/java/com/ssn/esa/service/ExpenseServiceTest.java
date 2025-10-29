package com.ssn.esa.service;

import com.ssn.esa.dto.*;
import com.ssn.esa.entity.*;
import com.ssn.esa.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test for ExpenseService
 */
public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonService personService;

    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateExpense_Success() {
        // Mock persons
        Person paidBy = new Person();
        paidBy.setId("1");
        paidBy.setName("Alice");
        paidBy.setEmail("alice@mail.com");
        paidBy.setBalance(500.0);

        Person participant1 = new Person();
        participant1.setId("2");
        participant1.setName("Bob");
        participant1.setEmail("bob@mail.com");
        participant1.setBalance(300.0);

        when(personRepository.findById("1")).thenReturn(Optional.of(paidBy));
        when(personRepository.findById("2")).thenReturn(Optional.of(participant1));

        List<ExpenseParticipantDTO> participants = new ArrayList<>();
        participants.add(new ExpenseParticipantDTO("2", 50.0));

        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setDescription("Lunch");
        expenseDTO.setTotalAmount(50.0);
        expenseDTO.setPaidBy("1");
        expenseDTO.setParticipants(participants);
        expenseDTO.setCategory("Food");

        Expense savedExpense = new Expense();
        savedExpense.setId("E1");
        when(expenseRepository.save(any(Expense.class))).thenReturn(savedExpense);

        Expense result = expenseService.createExpense(expenseDTO);

        assertNotNull(result);
        verify(expenseRepository, times(1)).save(any(Expense.class));
    }

    @Test
    void testPayExpense_Success() {
        // Mock person
        Person person = new Person();
        person.setId("2");
        person.setName("Bob");
        person.setBalance(100.0);

        // Mock participant
        ExpenseParticipant participant = new ExpenseParticipant("2", "Bob", 50.0);
        participant.setIsPaid(false);

        // Mock expense
        Expense expense = new Expense();
        expense.setId("E1");
        expense.setParticipants(List.of(participant));

        when(personService.getPersonById("2")).thenReturn(person);
        when(expenseRepository.findById("E1")).thenReturn(Optional.of(expense));
        when(personService.deductBalance("2", 50.0)).thenReturn(person);
        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);

        PaymentResponseDTO response = expenseService.payExpense("E1", "2");

        assertTrue(response.getSuccess());
        assertEquals("Payment successful", response.getMessage());
        verify(expenseRepository, times(1)).save(any(Expense.class));
    }

    @Test
    void testCreateExpense_ThrowsWhenInvalidShares() {
        Person paidBy = new Person();
        paidBy.setId("1");
        paidBy.setName("Alice");
        paidBy.setBalance(500.0);

        Person participant = new Person();
        participant.setId("2");
        participant.setName("Bob");
        participant.setBalance(200.0);

        when(personRepository.findById("1")).thenReturn(Optional.of(paidBy));
        when(personRepository.findById("2")).thenReturn(Optional.of(participant));

        ExpenseDTO dto = new ExpenseDTO();
        dto.setDescription("Mismatch");
        dto.setTotalAmount(100.0);
        dto.setPaidBy("1");
        dto.setParticipants(List.of(new ExpenseParticipantDTO("2", 50.0)));

        assertThrows(IllegalArgumentException.class, () -> expenseService.createExpense(dto));
    }
}
