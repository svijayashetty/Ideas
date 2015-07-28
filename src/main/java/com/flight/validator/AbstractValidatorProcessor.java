package com.flight.validator;

import java.util.List;

import com.flight.exception.ValidationError;

public abstract class AbstractValidatorProcessor<I, S> implements
		ValidatorProcessor<I, S> {

	private ValidatorProcessor<I, S> nextValidator;

	@Override
	public void setNextValidatorProcessor(ValidatorProcessor<I, S> nextValidator) {
		this.nextValidator = nextValidator;
	}

	@Override
	public List<ValidationError> doValidation(I input, S support,
			List<ValidationError> validationErrors) {
		List<ValidationError> errors = doIndividualValidation(input, support);
		validationErrors.addAll(errors);
		if (null != this.nextValidator) {
			this.nextValidator.doValidation(input, support, validationErrors);
		}
		return validationErrors;
	}

	protected abstract List<ValidationError> doIndividualValidation(I input,
			S support);
}
