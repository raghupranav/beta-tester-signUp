package com.beta.testers.signup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class GenericException  {

	// ========================================
	// Class Variables
	// ========================================

	private static final long serialVersionUID = 195403901982022276L;

	// ========================================
	// Instance Variables
	// ========================================

	private String errorMessage;
}
