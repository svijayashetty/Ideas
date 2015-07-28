package com.flight.processor;

import java.util.LinkedList;

import com.flight.constant.InputReaderType;
import com.flight.constant.OutPutWriterType;
import com.flight.constant.ShortestPathAlgoName;
import com.flight.exception.NotFoundException;
import com.flight.factory.output.printer.OutputWriterFactory;
import com.flight.factory.processor.ShortestPathProcessorFactory;
import com.flight.factory.reader.InputReaderFactory;
import com.flight.main.Main;
import com.flight.model.Airport;
import com.flight.model.Graph;
import com.flight.model.ShortestPath;
import com.flight.output.printer.OutputWriter;
import com.flight.reader.InputReader;

public class ShortestPathServiceImpl extends AbstractShortestPathService {

	private InputReader fileInputReader;

	private OutputWriter consoleOutputWriter;

	private ShortestPathProcessorFactory shortestPathProcessorFactory;

	private static final ShortestPathServiceImpl INSTANCE = new ShortestPathServiceImpl();

	public static ShortestPathServiceImpl createInstance() {
		return INSTANCE;
	}

	private ShortestPathServiceImpl() {
		super();
		fileInputReader = InputReaderFactory.createInstance().createInputReader(
				InputReaderType.FILEINPUTREADER);
		consoleOutputWriter = OutputWriterFactory.createInstance()
				.createOutputWriter(OutPutWriterType.CONSOLEOUTPUTWRITERTYPE);
		shortestPathProcessorFactory = ShortestPathProcessorFactory
				.createInstance();
	}

	@Override
	protected Graph readInputAndFormGraph() {
		return fileInputReader.readInput(Main.FILE_PATH);
	}
	@Override
	protected ShortestPath findShortestPath(final Airport source,
			final Airport destination, final Graph graph) {
		ShortestPathProcessor processor = shortestPathProcessorFactory
				.createShortestPathProcessor(ShortestPathAlgoName.DIJKSTRA,
						graph);
		LinkedList<Airport> paths = processor.findShortestPath(source,
				destination);
		if (null == paths || paths.isEmpty()) {
			throw new NotFoundException("No Path between source "
					+ source.getId() + " and destination "
					+ destination.getId());
		}
		Long cost = processor.findCostForTheShortestPath(paths, graph);
		return new ShortestPath(paths, cost);
	}

	@Override
	protected void writeOutput(ShortestPath shortestPath, Airport source,
			Airport destination) {
		consoleOutputWriter.write("Shortest Path between Vertex "
				+ source.getId() + " to target " + destination.getId() + " is "
				+ shortestPath.getShortestPaths());
		consoleOutputWriter.write("The Cost of Shortest Path is:: "
				+ shortestPath.getCost());
	}

}
