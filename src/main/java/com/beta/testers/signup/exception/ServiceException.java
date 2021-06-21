package com.beta.testers.signup.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends Exception {
	// ========================================
	// Class Variables
	// ========================================
	
	private static final long serialVersionUID = -393300627492545337L;
	
	// ========================================
	// Instance Variables
	// ========================================

	private String errorMessage;
	private HttpStatus httpStatus;
}
