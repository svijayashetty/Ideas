package com.flight.validator;

import java.util.List;

import com.flight.model.Airport;

public class AirportValidatorChain implements
		ValidationChain<String, List<Airport>> {

	private static final AirportValidatorChain instance = new AirportValidatorChain();

	private ValidatorProcessor<String, List<Airport>> airportValidator;

	private AirportValidatorChain() {
		airportValidator = AirportValidator.createInstance();
	}

	public static AirportValidatorChain createInstance() {
		return instance;
	}

	@Override
	public ValidatorProcessor<String, List<Airport>> createChain(String i,
			List<Airport> s) {
		return airportValidator;
	}

}
