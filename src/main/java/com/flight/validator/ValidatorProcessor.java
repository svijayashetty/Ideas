package com.flight.validator;

import com.flight.exception.ValidationError;

import java.util.List;

public interface ValidatorProcessor<I, S> {

	void setNextValidatorProcessor(ValidatorProcessor<I, S> nextValidator);

	List<ValidationError> doValidation(I input, S support,
			List<ValidationError> validationErrors);
}
