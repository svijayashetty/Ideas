package com.flight.factory.reader;

import com.flight.constant.InputReaderType;
import com.flight.exception.NotFoundException;
import com.flight.reader.FileInputReader;
import com.flight.reader.InputReader;

public class InputReaderFactory {

    private static final InputReaderFactory instance = new InputReaderFactory();

    private InputReaderFactory() {
    }

    public static InputReaderFactory createInstance() {
        return instance;
    }

    @SuppressWarnings("incomplete-switch")
    public InputReader createInputReader(final InputReaderType type) {
        switch (type) {
        case FILEINPUTREADER:
            return FileInputReader.createInstance();
        }
        throw new NotFoundException("InputReaderType " + type + " not supported");
    }
}
