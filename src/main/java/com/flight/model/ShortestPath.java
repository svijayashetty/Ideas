package com.flight.model;

import java.util.LinkedList;

public class ShortestPath {

	private LinkedList<Airport> shortestPaths;

	private Long cost;

	public ShortestPath(LinkedList<Airport> shortestPaths, Long cost) {
		if (null != shortestPaths && !shortestPaths.isEmpty()) {
			this.shortestPaths = (LinkedList) shortestPaths.clone();
		}
		this.cost = cost;
	}

	public LinkedList<Airport> getShortestPaths() {
		return shortestPaths;
	}

	public Long getCost() {
		return cost;
	}

}
