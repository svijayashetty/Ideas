package com.flight.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import com.flight.constant.OutPutWriterType;
import com.flight.exception.SystemException;
import com.flight.factory.output.printer.OutputWriterFactory;
import com.flight.model.Route;
import com.flight.model.Graph;
import com.flight.model.Airport;

public class FileInputReader implements InputReader {

    private static final FileInputReader instance = new FileInputReader();

    private FileInputReader() {

    }

    public static FileInputReader createInstance() {
        return instance;
    }

    @Override
    public Graph readInput(String path) {
        CSVReader reader = null;
        List<Route> routes = new ArrayList<Route>();
        List<Airport> airports = new ArrayList<Airport>();
        Graph graph = new Graph();
        try {
            reader = new CSVReader(new FileReader(path));
            String[] nextLine;
            Integer counter = 0;
            while ((nextLine = reader.readNext()) != null) {
                counter = counter + 1;
                String flightId = "Flight_" + counter;
                Airport sourceAirport = new Airport(nextLine[0], nextLine[0]);
                airports.add(sourceAirport);
                Airport destinationAirport = new Airport(nextLine[1], nextLine[1]);
                airports.add(destinationAirport);
                Route route = new Route(flightId, sourceAirport, destinationAirport, Integer.parseInt(nextLine[2]));
                routes.add(route);
                graph.addAirport(sourceAirport);
                graph.addAirport(destinationAirport);
                graph.addRoute(route);
            }

            OutputWriterFactory.createInstance().createOutputWriter(OutPutWriterType.CONSOLEOUTPUTWRITERTYPE)
                    .write("Input :" + graph);
            return graph;
        } catch (IOException e) {
            throw new SystemException("Technical Exception. The exception is " + e.getMessage(), e);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new SystemException("Technical Exception while closing the resourse. The exception is "
                            + e.getMessage(), e);
                }
            }
        }
    }
}
