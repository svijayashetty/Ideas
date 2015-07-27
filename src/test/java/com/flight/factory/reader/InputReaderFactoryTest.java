package com.flight.factory.reader;

import org.junit.Assert;
import org.junit.Test;

import com.flight.constant.InputReaderType;
import com.flight.exception.NotFoundException;
import com.flight.reader.FileInputReader;
import com.flight.reader.InputReader;

public class InputReaderFactoryTest {

    InputReaderFactory inputReaderFactory = InputReaderFactory.createInstance();

    @Test
    public void testCreateInputReaderReturnsInstanceOfConsoleWriter() {
        InputReader inputReader = inputReaderFactory.createInputReader(InputReaderType.FILEINPUTREADER);
        Assert.assertTrue(inputReader instanceof FileInputReader);
    }

    @Test(expected = NotFoundException.class)
    public void testCreateInputReaderReturnsExceptionWhenUnimplementedWriter() {
        inputReaderFactory.createInputReader(InputReaderType.DBINPUTREADER);
    }
}
