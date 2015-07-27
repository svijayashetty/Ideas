package com.flight.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flight.model.Airport;
import com.flight.model.Graph;
import com.flight.model.Route;

public class DijkstraAlgorithm implements ShortestPathProcessor {

    private final List<Route> edges;
    private Set<Airport> settledNodes;
    private Set<Airport> unSettledNodes;
    private Map<Airport, Airport> predecessors;
    private Map<Airport, Integer> distance;

    public DijkstraAlgorithm(Graph graph) {
        this.edges = new ArrayList<Route>(graph.getRoutes());
    }

    @Override
    public LinkedList<Airport> findShortestPath(final Airport source, final Airport destination) {
        settledNodes = new HashSet<Airport>();
        unSettledNodes = new HashSet<Airport>();
        distance = new HashMap<Airport, Integer>();
        predecessors = new HashMap<Airport, Airport>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Airport node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
        LinkedList<Airport> paths = getPath(destination);
        return paths;
    }

    private void findMinimalDistances(Airport node) {
        List<Airport> adjacentNodes = getNeighbors(node);
        for (Airport target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private int getDistance(Airport node, Airport target) {
        for (Route edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
                return 1;
            }
        }
        return 0;
    }

    private List<Airport> getNeighbors(Airport node) {
        List<Airport> neighbors = new ArrayList<Airport>();
        for (Route edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Airport getMinimum(Set<Airport> vertexes) {
        Airport minimum = null;
        for (Airport vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Airport vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Airport destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    private LinkedList<Airport> getPath(Airport target) {
        LinkedList<Airport> path = new LinkedList<Airport>();
        Airport step = target;
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

    @Override
    public Long findCostForTheShortestPath(final LinkedList<Airport> paths, final Graph graph) {
        if (null != paths && !paths.isEmpty()) {
            Long costs = new Long(0);
            for (int i = 0; i < paths.size(); i++) {
                if (i < paths.size() - 1) {
                    Integer cost = graph.findCost(paths.get(i), paths.get(i + 1));
                    costs = costs + cost;
                }
            }
            return costs;
        }
        return null;
    }
}