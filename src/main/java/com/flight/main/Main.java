package com.flight.main;

import com.flight.processor.ServiceFacade;

public class Main {

    public static final String FILE_PATH = "/Users/vijayals/Documents/flightbooking/src/main/resources/input.csv";

    public static void main(String[] args) {
        // InputReader reader = InputReaderFactory.createInstance().createInputReader(InputReaderType.FILEINPUTREADER);
        // Graph graph = reader.readInput(FILE_PATH);
        // Airport source = new Airport("h", "h");
        // Airport destination = new Airport("e", "e");
        // ShortestPathProcessor dij = ShortestPathProcessorFactory.createInstance().createShortestPathProcessor(
        // ShortestPathAlgoName.DIJKSTRA, graph);
        // LinkedList<Airport> paths = dij.findShortestPath(source, destination);
        // OutputWriter writer = OutputWriterFactory.createInstance().createOutputWriter(
        // OutPutWriterType.CONSOLEOUTPUTWRITERTYPE);
        // writer.write("\n\nShortest Path between Vertex " + source.getId() + " to target " + destination.getId()
        // + " is :\n" + paths);
        // writer.write("The Cost of Shortest Path is:: " + dij.findCostForTheShortestPath(paths, graph));
        ServiceFacade serviceFacade = new ServiceFacade();
        serviceFacade.calculateShortestPath("h", "e");

    }
}
