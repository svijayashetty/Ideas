package com.flight.factory.output.printer;

import com.flight.constant.OutPutWriterType;
import com.flight.exception.NotFoundException;
import com.flight.output.printer.ConsoleWriter;
import com.flight.output.printer.OutputWriter;

public class OutputWriterFactory {

    private static final OutputWriterFactory instance = new OutputWriterFactory();

    private OutputWriterFactory() {
    }

    public static OutputWriterFactory createInstance() {
        return instance;
    }

    @SuppressWarnings("incomplete-switch")
    public OutputWriter createOutputWriter(final OutPutWriterType type) {
        switch (type) {
        case CONSOLEOUTPUTWRITERTYPE:
            return ConsoleWriter.createInsance();
        }
        throw new NotFoundException("The OutPutWriterType " + type + " not supported");
    }
}
