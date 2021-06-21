package com.beta.testers.signup.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BaseClass implements Serializable {
	// ========================================
	// Class Variables
	// ========================================

	private static final long serialVersionUID = 982477223687793567L;

	// ========================================
	// Instance Variables
	// ========================================

	private String requestId;
}
