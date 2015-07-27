package com.flight.processor;

import java.util.LinkedList;

import com.flight.model.Airport;
import com.flight.model.Graph;

public interface ShortestPathProcessor {

    LinkedList<Airport> findShortestPath(final Airport source, final Airport destination);

    Long findCostForTheShortestPath(LinkedList<Airport> paths, Graph graph);
}
