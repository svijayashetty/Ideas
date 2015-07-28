package com.flight.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Airport> airports;
    private List<Route> routes;

    public Graph() {
    }

    public List<Airport> getAirports() {
        if (null == this.airports) {
            this.airports = new ArrayList<Airport>();
        }
        return airports;
    }

    public List<Route> getRoutes() {
        if (null == this.routes) {
            this.routes = new ArrayList<Route>();
        }
        return routes;
    }

    public void addAirport(final Airport airport) {
        if (null != airport) {
            getAirports().add(airport);
        }
    }

    public void addRoute(final Route route) {
        if (null != route) {
            getRoutes().add(route);
        }
    }

    public Integer findCost(final Airport source, final Airport target) {
        List<Route> routes = getRoutes();
        for (Route route : routes) {
            if (route.getSource().equals(source) && route.getDestination().equals(target)) {
                return 1;
            }
        }
        return null;
    }

    public Airport findAirportBasedOnId(final String airportId) {
        for (Airport airport : getAirports()) {
            if (airport.getId().equalsIgnoreCase(airportId)) {
                return airport;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "\nRoutes :" + routes + "";
    }
}
