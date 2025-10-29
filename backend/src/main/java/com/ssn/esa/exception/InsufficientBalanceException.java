package com.ssn.esa.exception;

/**
 * Custom exception for insufficient balance scenarios
 */
public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(String message) {
        super(message);
    }
    
    public InsufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}