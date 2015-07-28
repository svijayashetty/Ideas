package com.flight.factory.processor;

import com.flight.processor.ShortestPathService;
import com.flight.processor.ShortestPathServiceImpl;

public class ShortestPathServiceFactory {

	private static final ShortestPathServiceFactory instance = new ShortestPathServiceFactory();
	
	private ShortestPathService shortestPathServiceImpl;
	
	private ShortestPathServiceFactory() {
		shortestPathServiceImpl = ShortestPathServiceImpl.createInstance();
	}

	public static ShortestPathServiceFactory createInstance() {
		return instance;
	}
	
	public ShortestPathService createShortestPathProcessor() {
		return shortestPathServiceImpl;
	}
}
