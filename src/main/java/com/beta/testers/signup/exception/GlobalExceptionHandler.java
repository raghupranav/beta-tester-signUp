package com.beta.testers.signup.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.beta.testers.signup.dto.GenericException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	// Class variables

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	// Instance variables

	@ExceptionHandler({ ServiceException.class })
	public ResponseEntity<GenericException> handleGenericException(ServiceException serviceException) {
		return new ResponseEntity<>(new GenericException(serviceException.getErrorMessage()), serviceException.getHttpStatus());
	}
}
