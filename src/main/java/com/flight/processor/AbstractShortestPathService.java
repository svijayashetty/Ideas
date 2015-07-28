package com.flight.processor;

import java.util.List;

import com.flight.exception.ValidationError;
import com.flight.exception.ValidationException;
import com.flight.model.Airport;
import com.flight.model.Graph;
import com.flight.model.ShortestPath;
import com.flight.validator.AirportValidatorChain;
import com.flight.validator.ValidationChain;
import com.flight.validator.ValidationProcessor;

public abstract class AbstractShortestPathService implements
		ShortestPathService {

	private ValidationProcessor validationProcessor;

	private ValidationChain<String, List<Airport>> airportValidationChain;

	protected AbstractShortestPathService() {
		this.validationProcessor = ValidationProcessor.createInstance();
		this.airportValidationChain = AirportValidatorChain.createInstance();
	}

	@Override
	public ShortestPath calculateShortestPath(final String sourceAirportId,
			final String destinationAirportId) {
		Graph graph = readInputAndFormGraph();
		doValidation(sourceAirportId, destinationAirportId, graph.getAirports());
		Airport sourceAirport = graph.findAirportBasedOnId(sourceAirportId);
		Airport destinationAirport = graph
				.findAirportBasedOnId(destinationAirportId);
		ShortestPath path = findShortestPath(sourceAirport, destinationAirport,
				graph);
		writeOutput(path, sourceAirport, destinationAirport);
		return path;
	}

	private void doValidation(final String sourceAirportId,
			final String destinationAirportId, final List<Airport> list) {
		List<ValidationError> errors = this.validationProcessor.doValidation(
				this.airportValidationChain, sourceAirportId, list);
		errors.addAll(this.validationProcessor.doValidation(
				this.airportValidationChain, destinationAirportId, list));
		if (null != errors && !errors.isEmpty()) {
			throw new ValidationException("Validation Errors", errors);
		}
	}

	protected abstract Graph readInputAndFormGraph();

	protected abstract ShortestPath findShortestPath(final Airport source,
			final Airport destination, final Graph graph);

	protected abstract void writeOutput(ShortestPath shortestPath,
			Airport source, Airport destination);

}
