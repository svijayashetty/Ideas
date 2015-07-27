package com.flight.main;

import java.util.LinkedList;

import com.flight.constant.InputReaderType;
import com.flight.constant.OutPutWriterType;
import com.flight.constant.ShortestPathAlgoName;
import com.flight.factory.output.printer.OutputWriterFactory;
import com.flight.factory.processor.ShortestPathProcessorFactory;
import com.flight.factory.reader.InputReaderFactory;
import com.flight.model.Graph;
import com.flight.model.Airport;
import com.flight.output.printer.OutputWriter;
import com.flight.processor.ShortestPathProcessor;
import com.flight.reader.InputReader;

public class Main {

    public static final String FILE_PATH = "/Users/vijayals/Documents/flightbooking/src/main/resources/input.csv";

    public static void main(String[] args) {
        InputReader reader = InputReaderFactory.createInstance().createInputReader(InputReaderType.FILEINPUTREADER);
        Graph graph = reader.readInput(FILE_PATH);
        Airport source = new Airport("h", "h");
        Airport destination = new Airport("e", "e");
        ShortestPathProcessor dij = ShortestPathProcessorFactory.createInstance().createShortestPathProcessor(
                ShortestPathAlgoName.DIJKSTRA, graph);
        LinkedList<Airport> paths = dij.findShortestPath(source, destination);
        OutputWriter writer = OutputWriterFactory.createInstance().createOutputWriter(
                OutPutWriterType.CONSOLEOUTPUTWRITERTYPE);
        writer.write("\n\nShortest Path between Vertex " + source.getId() + " to target " + destination.getId()
                + " is :\n" + paths);
        writer.write("The Cost of Shortest Path is:: " + dij.findCostForTheShortestPath(paths, graph));
    }
}
