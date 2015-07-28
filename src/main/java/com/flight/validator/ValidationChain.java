package com.flight.validator;

public interface ValidationChain<I,S> {
	
	ValidatorProcessor<I, S> createChain(I i, S s);
}
