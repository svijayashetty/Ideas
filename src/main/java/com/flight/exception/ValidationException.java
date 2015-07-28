package com.flight.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException {

	private List<ValidationError> validationErrors;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(String message,
			List<ValidationError> validationErrors) {
		super(message);
		if (null != validationErrors && !validationErrors.isEmpty()) {
			this.validationErrors = validationErrors;
		}
	}

	public List<ValidationError> getValidationErrors() {
		if (null == this.validationErrors) {
			this.validationErrors = new ArrayList<ValidationError>();
		}
		return this.validationErrors;
	}
}
