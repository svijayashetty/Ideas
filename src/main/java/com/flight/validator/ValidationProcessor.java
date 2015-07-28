package com.flight.validator;

import java.util.ArrayList;
import java.util.List;

import com.flight.exception.ValidationError;

public class ValidationProcessor {

	private static final ValidationProcessor instance = new ValidationProcessor();

	private ValidationProcessor() {

	}

	public static ValidationProcessor createInstance() {
		return instance;
	}

	public <I, S> List<ValidationError> doValidation(
			final ValidationChain<I, S> chain, final I input, final S support) {
		ValidatorProcessor<I, S> validatorChain = chain.createChain(input,
				support);
		return validatorChain.doValidation(input, support,
				new ArrayList<ValidationError>());
	}
}
