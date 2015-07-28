package com.flight.processor;

import com.flight.factory.processor.ShortestPathServiceFactory;
import com.flight.model.ShortestPath;

public class ServiceFacade {

	private ShortestPathServiceFactory shortestPathServiceFactory;

	public ServiceFacade() {
		shortestPathServiceFactory = ShortestPathServiceFactory.createInstance();
	}

	public ShortestPath calculateShortestPath(final String sourceAirportId,
			final String destinationAirportId) {
		return shortestPathServiceFactory.createShortestPathProcessor()
				.calculateShortestPath(sourceAirportId, destinationAirportId);
	}
}
