package com.flight.validator;

import java.util.ArrayList;
import java.util.List;

import com.flight.exception.ValidationError;
import com.flight.model.Airport;

public class AirportValidator extends
		AbstractValidatorProcessor<String, List<Airport>> {
	
	private static final AirportValidator INSTANCE = new AirportValidator();
	
	public static AirportValidator createInstance() {
		return INSTANCE;
	}

	@Override
	protected List<ValidationError> doIndividualValidation(final String input,
			final List<Airport> support) {
		List<ValidationError> validationErrors = new ArrayList<ValidationError>();
		ValidationError validationError = null;
		for (Airport airport : support) {
			if (airport.getId().equalsIgnoreCase(input)) {
				return validationErrors;
			}
		}
		if (null == input || input.trim().length() == 0) {
			validationError = new ValidationError("ERR_NULL_ID",
					"The input airport id can not be null");
		} else {
			validationError = new ValidationError("ERR_ID_NOT_FOUND",
					"The Airport id " + input + " does not exists");
		}
		validationErrors.add(validationError);
		return validationErrors;
	}

}
