package com.flight.factory.processor;

import org.junit.Assert;
import org.junit.Test;

import com.flight.constant.ShortestPathAlgoName;
import com.flight.exception.NotFoundException;
import com.flight.model.Graph;
import com.flight.processor.DijkstraAlgorithm;
import com.flight.processor.ShortestPathProcessor;

public class ShortestPathProcessorFactoryTest {

    ShortestPathProcessorFactory shortestPathProcessorFactory = ShortestPathProcessorFactory.createInstance();
    Graph graph = new Graph();

    @Test
    public void testCreateShortestPathProcessorReturnsInstanceOfConsoleWriter() {
        ShortestPathProcessor shortestPathProcessor = shortestPathProcessorFactory.createShortestPathProcessor(
                ShortestPathAlgoName.DIJKSTRA, graph);
        Assert.assertTrue(shortestPathProcessor instanceof DijkstraAlgorithm);
    }

    @Test(expected = NotFoundException.class)
    public void testCreateShortestPathProcessorReturnsExceptionWhenUnimplementedWriter() {
        shortestPathProcessorFactory.createShortestPathProcessor(ShortestPathAlgoName.BREADTHFIRST, graph);
    }

}
