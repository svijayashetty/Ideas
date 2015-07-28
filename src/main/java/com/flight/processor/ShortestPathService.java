package com.flight.processor;

import com.flight.model.ShortestPath;

public interface ShortestPathService {

	ShortestPath calculateShortestPath(String sourceAirportId,
			String destinationAirportId);
}
