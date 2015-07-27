package com.flight.factory.output.printer;

import org.junit.Assert;
import org.junit.Test;

import com.flight.constant.OutPutWriterType;
import com.flight.exception.NotFoundException;
import com.flight.output.printer.ConsoleWriter;
import com.flight.output.printer.OutputWriter;

public class OutputWriterFactoryTest {

    OutputWriterFactory outputWriterFactory = OutputWriterFactory.createInstance();

    @Test
    public void testCreateOutputWriterReturnsInstanceOfConsoleWriter() {
        OutputWriter outputWriter = outputWriterFactory.createOutputWriter(OutPutWriterType.CONSOLEOUTPUTWRITERTYPE);
        Assert.assertTrue(outputWriter instanceof ConsoleWriter);
    }

    @Test(expected = NotFoundException.class)
    public void testCreateOutputWriterReturnsExceptionWhenUnimplementedWriter() {
        outputWriterFactory.createOutputWriter(OutPutWriterType.DBOUTPUTWRITERTYPE);
    }

}
