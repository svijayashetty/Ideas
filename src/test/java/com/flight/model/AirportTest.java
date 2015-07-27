package com.flight.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirportTest {

    private static final String PNQ = "PNQ";
    private static final String PUNE = "PUNE";
    Airport airportA, airportB, airportC;

    @Before
    public void init() {
        airportA = new Airport(PNQ, PUNE);
        airportB = new Airport(PNQ, PUNE);
        airportC = new Airport(null, PUNE);
    }

    @Test
    public void testHashCode() {
        Assert.assertTrue(airportA.hashCode() == airportB.hashCode());
        Assert.assertTrue(airportC.hashCode() == 31);

    }

    @Test
    public void testGetId() {
        Assert.assertTrue(airportA.getId().equals(PNQ));
    }

    @Test
    public void testGetName() {
        Assert.assertTrue(airportA.getName().equals(PUNE));
    }

    @Test
    public void testEqualsObject() {
        Assert.assertTrue(airportA.equals(airportB));
        Assert.assertFalse(airportA.equals(null));
        Assert.assertFalse(airportA.equals("String"));
        Assert.assertFalse(airportC.equals(airportA));

    }

    @Test
    public void testToString() {
        Assert.assertTrue(airportA.toString().equals("Airport PUNE"));
    }

}
