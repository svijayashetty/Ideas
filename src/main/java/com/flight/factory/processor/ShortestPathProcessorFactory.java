package com.flight.factory.processor;

import com.flight.constant.ShortestPathAlgoName;
import com.flight.exception.NotFoundException;
import com.flight.model.Graph;
import com.flight.processor.DijkstraAlgorithm;
import com.flight.processor.ShortestPathProcessor;

public class ShortestPathProcessorFactory {

    private static final ShortestPathProcessorFactory instance = new ShortestPathProcessorFactory();

    private ShortestPathProcessorFactory() {
    }

    public static ShortestPathProcessorFactory createInstance() {
        return instance;
    }

    @SuppressWarnings("incomplete-switch")
    public ShortestPathProcessor createShortestPathProcessor(final ShortestPathAlgoName shortestPathAlgoName,
            final Graph graph) {
        switch (shortestPathAlgoName) {
        case DIJKSTRA:
            return new DijkstraAlgorithm(graph);
        }
        throw new NotFoundException("The Algorithm " + shortestPathAlgoName.name() + " is not supported as of now");
    }
}
