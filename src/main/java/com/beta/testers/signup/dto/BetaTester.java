package com.beta.testers.signup.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BetaTester extends BaseClass {
	
	// ========================================
	// Class Variables
	// ========================================
	
	private static final long serialVersionUID = -2805161717818528394L;
	
	// ========================================
	// Instance Variables
	// ========================================
	
	private String betaTesterId;
	private String firstName;
	private String lastName;
	private String product;
	private String registeredTimestamp;
	private String emailId;
	private Map<String, String> socialMediaHandles;
	private Map<String, String> developmentTools ;
	private String location;

}
