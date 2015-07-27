package com.flight.output.printer;

public class ConsoleWriter implements OutputWriter {

    private static final ConsoleWriter instance = new ConsoleWriter();

    private ConsoleWriter() {
    }

    public static ConsoleWriter createInsance() {
        return instance;
    }

    @Override
    public void write(final String msg) {
        System.out.println(msg);
    }
}
