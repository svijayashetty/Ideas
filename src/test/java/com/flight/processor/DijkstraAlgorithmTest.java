package com.flight.processor;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.flight.model.Airport;
import com.flight.model.Graph;
import com.flight.model.Route;

public class DijkstraAlgorithmTest {

    DijkstraAlgorithm dijkstraAlgorithm;
    Airport source, destination;
    Graph graph;

    @Before
    public void init() {
        Airport pune = new Airport("PNQ", "PUNE");
        Airport mumbai = new Airport("MUM", "MUMBAI");
        Airport leh = new Airport("LHX", "LEH");
        Airport delhi = new Airport("DLH", "DELHI");
        Route pun_leh = new Route("Route_1", pune, leh, 1);
        Route pun_mum = new Route("Route_2", pune, mumbai, 5);
        Route mum_del = new Route("Route_3", mumbai, delhi, 3);
        Route del_leh = new Route("Route_4", delhi, leh, 2);

        graph = new Graph();

        graph.addAirport(pune);
        graph.addAirport(mumbai);
        graph.addAirport(leh);
        graph.addAirport(delhi);

        graph.addRoute(del_leh);
        graph.addRoute(mum_del);
        graph.addRoute(pun_leh);
        graph.addRoute(pun_mum);

        dijkstraAlgorithm = new DijkstraAlgorithm(graph);

        source = pune;
        destination = leh;
    }

    @Test
    public void testFindShortestPathMethodReturnsCorrectList() {
        List<Airport> path = dijkstraAlgorithm.findShortestPath(source, destination);
        Assert.assertTrue(path.contains(source));
        Assert.assertTrue(path.contains(destination));
        Assert.assertEquals(path.size(), 2);
    }

    @Test
    public void testFindCostForTheShortestPathMethodReturnsCorrectList() {
        LinkedList<Airport> path = dijkstraAlgorithm.findShortestPath(source, destination);
        long cost = dijkstraAlgorithm.findCostForTheShortestPath(path, graph);
        Assert.assertEquals(cost, 1);
    }

}
