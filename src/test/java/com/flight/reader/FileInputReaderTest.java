package com.flight.reader;

import org.junit.Test;

import com.flight.exception.SystemException;
import com.flight.main.Main;

public class FileInputReaderTest {

    FileInputReader fileInputReader = FileInputReader.createInstance();

    @Test(expected = SystemException.class)
    public void testReadInputShouldThrowExceptionWhenInvalidFilePathProvided() {
        fileInputReader.readInput("invalid");
    }

    @Test
    public void testReadInputValidShouldReturnGraphWhenProperInputProvided() {
        fileInputReader.readInput(Main.FILE_PATH);
    }

}
