package com.flight.model;

public class Route {

    private String id;
    private Airport source;
    private Airport destination;
    private Integer frequency;

    public Route(String id, Airport source, Airport destination, Integer frequency) {
        super();
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.frequency = frequency;
    }

    public String getId() {
        return id;
    }

    public Airport getSource() {
        return source;
    }

    public Airport getDestination() {
        return destination;
    }

    public Integer getFrequency() {
        return frequency;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Route other = (Route) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // return "Route [id=" + id + ", source=" + source + ", destination=" + destination + ", frequency=" + frequency
        // + "]";
        return "\nRoute :" + source + "->" + destination;
    }
}
